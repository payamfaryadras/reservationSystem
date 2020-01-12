package com.payam.learn.reservation.config.security;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.payam.learn.reservation.dto.model.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.payam.learn.reservation.config.security.SecurityConstant.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", "POST"));

    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            String password = request.getParameter(SPRING_SECURITY_FORM_PASSWORD_KEY);
            String email = request.getParameter("email");

            return authenticationManager.
                    authenticate(new
                            UsernamePasswordAuthenticationToken(
                                    email,
                                    password,
                                    new ArrayList<>()));

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return super.attemptAuthentication(request, response);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        if(authResult.getPrincipal() != null){
            org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authResult.getPrincipal();
            String login = user.getUsername();
            if (login != null && login.length() > 0) {
                Claims claims = Jwts.claims().setSubject(login);
                List<String> roles = new ArrayList<>();
                user.getAuthorities().stream().forEach(authority -> roles.add(authority.getAuthority()));
                claims.put("roles", roles);
                String token = Jwts.builder()
                        .setClaims(claims)
                        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                        .signWith(SignatureAlgorithm.HS512, SECRET)
                        .compact();
                response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
            }
        }


        super.successfulAuthentication(request, response, chain, authResult);
    }
}

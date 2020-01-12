package com.payam.learn.reservation.config.security;


import com.payam.learn.reservation.services.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/signup").permitAll()
                .antMatchers("/dashboard/**").hasAuthority("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .authorizeRequests().antMatchers("/h2-console/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .failureUrl("/login?error=true")
                .successHandler(customAuthenticationSuccessHandler)
                .and()
                .logout()
                .permitAll()

                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessHandler(new CustomLogoutSuccessHandler())

                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling();
               /*   .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);*/
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/h2-console/**",
                "/resources/static/**", "/css/**", "/js/**", "/img/**", "/fonts/**",
                "/images/**", "/scss/**", "/vendor/**", "/favicon.ico", "/auth/**", "/favicon.png",
                "/v2/api-docs", "/configuration/ui", "/configuration/security", "/swagger-ui.html",
                "/webjars/**", "/swagger-resources/**", "/swagge‌​r-ui.html", "/actuator",
                "/actuator/**");
    }
}

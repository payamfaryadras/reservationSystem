package com.payam.learn.reservation.services.security;

import com.payam.learn.reservation.dto.model.RoleDto;
import com.payam.learn.reservation.dto.model.UserDto;
import com.payam.learn.reservation.model.User;
import com.payam.learn.reservation.repositories.UserRepository;
import com.payam.learn.reservation.services.UserService;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDto user = userService.findUserByEmail(email);
        if (user != null) {
            return buildUserForAuthentication(user, getUserAuthority(user.getRoles()));
        }

//TODO
        throw new RuntimeException("The user doesn't exist!");
    }

    private List<GrantedAuthority> getUserAuthority(Set<RoleDto> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        userRoles.forEach((role) -> {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        });
        return new ArrayList<GrantedAuthority>(roles);
    }

    private UserDetails buildUserForAuthentication(UserDto user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);

    }

}

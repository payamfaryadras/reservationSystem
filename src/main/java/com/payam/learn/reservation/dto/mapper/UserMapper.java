package com.payam.learn.reservation.dto.mapper;

import com.payam.learn.reservation.dto.model.RoleDto;
import com.payam.learn.reservation.dto.model.UserDto;
import com.payam.learn.reservation.model.Role;
import com.payam.learn.reservation.model.User;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

public final class UserMapper {


    public static final UserDto UserToUserDto(User user) {
        return new UserDto().setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setRoles(new HashSet<>(user.getRoles()
                        .stream()
                        .map(role -> new ModelMapper().map(role, RoleDto.class)).collect(
                                Collectors.toSet()
                        )));

    }


}

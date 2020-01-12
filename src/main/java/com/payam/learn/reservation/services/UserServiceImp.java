package com.payam.learn.reservation.services;

import com.payam.learn.reservation.dto.mapper.UserMapper;
import com.payam.learn.reservation.dto.model.RoleDto;
import com.payam.learn.reservation.dto.model.UserDto;
import com.payam.learn.reservation.model.Role;
import com.payam.learn.reservation.model.User;
import com.payam.learn.reservation.repositories.RoleRepository;
import com.payam.learn.reservation.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDto register(UserDto userDto) {
        User user = userRepository.findByEmail(userDto.getEmail());

        if (user == null) {
            Role role = roleRepository.findByRole("ADMIN");
            HashSet<Role> roles = new HashSet<>();
            roles.add(role);
            User newUser = new User().setEmail(userDto.getEmail())
                    .setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()))
                    .setRoles(roles);

            return UserMapper.UserToUserDto(userRepository.save(newUser));
        }
        //TODO
        throw new RuntimeException("The user already exists!!!");
    }

    @Override
    public UserDto findUserByEmail(String email) {

        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));
        if (user.isPresent()) {

            return UserMapper.UserToUserDto(user.get());
        }
//TODO
        throw new RuntimeException("The email doesn't exist!!!");
    }

    @Override
    public UserDto changePassword(UserDto userDto) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(userDto.getEmail()));
        if (user.isPresent()) {
            user.get().setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
            return UserMapper.UserToUserDto(userRepository.save(user.get()));
        }
        //Todo
        throw new RuntimeException("The user already doesn't exist!!!!");
    }
}

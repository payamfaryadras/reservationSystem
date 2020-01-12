package com.payam.learn.reservation.services;

import com.payam.learn.reservation.dto.model.UserDto;

/**
 *
 */
public interface UserService {


    /**
     * create A User
     * @param userDto
     * @return
     */
    UserDto register(UserDto userDto);


    /**
     * search A user via email
     * @param email
     * @return
     */
    UserDto findUserByEmail(String email);


    /**
     * update password
     * @param userDto
     * @return
     */
    UserDto changePassword(UserDto userDto);

}

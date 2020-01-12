package com.payam.learn.reservation.controller;

import com.payam.learn.reservation.config.security.TokenRequest;
import com.payam.learn.reservation.dto.model.RoleDto;
import com.payam.learn.reservation.dto.model.UserDto;
import com.payam.learn.reservation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashSet;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/", "/login"})
    public ModelAndView login() {
      return new ModelAndView("login");
    }

    @GetMapping(value = "/signup")
    public ModelAndView signup() {
        ModelAndView modelAndView = new ModelAndView("signup");
        modelAndView.addObject("userDto", new UserDto());
        return modelAndView;
    }

    @PostMapping(value = "/signup")
    public ModelAndView createUser(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("signup");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        } else {
            userService.register(userDto);
        }
        return new ModelAndView("login");

    }

}

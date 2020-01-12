package com.payam.learn.reservation.config.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public class TokenRequest {
    private String email;
    private String password;
}

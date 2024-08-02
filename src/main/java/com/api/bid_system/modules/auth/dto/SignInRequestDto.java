package com.api.bid_system.modules.auth.dto;

import lombok.Data;

@Data
public class SignInRequestDto {
    private String username;
    private String password;
}

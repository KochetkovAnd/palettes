package com.kochetkov.pallets.security;

import com.kochetkov.pallets.domain.enums.Role;
import lombok.Data;

@Data
public class RegisterRequestDTO {
    private String username;
    private String password;
    private Role role;
}

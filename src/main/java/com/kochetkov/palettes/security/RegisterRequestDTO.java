package com.kochetkov.palettes.security;

import com.kochetkov.palettes.domain.enums.Role;
import lombok.Data;

@Data
public class RegisterRequestDTO {
    private String username;
    private String password;
    private Role role;
}

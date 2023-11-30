package com.kochetkov.palettes.DTO;


import com.kochetkov.palettes.domain.enums.Role;

import lombok.Data;

@Data
public class UserDTO {
    private long id;
    private String username;
    private String password;
    private Role role;

}

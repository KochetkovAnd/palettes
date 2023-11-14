package com.kochetkov.pallets.DTO;


import com.kochetkov.pallets.domain.enums.Role;

import lombok.Data;

@Data
public class UserDTO {
    private long id;
    private String username;
    private String password;
    private Role role;

}

package com.example.hotel.Dto;

import java.util.Set;

import com.example.hotel.Entity.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequest {

    private Long id;
    private String username;
    private String password;
    private Set<UserRole> roles;

}

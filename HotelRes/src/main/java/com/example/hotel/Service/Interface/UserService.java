package com.example.hotel.Service.Interface;

import java.util.List;

import com.example.hotel.Dto.UserRequest;
import com.example.hotel.Dto.UserResponse;

public interface UserService {

    UserResponse saveUser(UserRequest userRequest);

    UserResponse getUserByUsername(String username);

    UserResponse getUser();

    List<UserResponse> getAllUser();

}

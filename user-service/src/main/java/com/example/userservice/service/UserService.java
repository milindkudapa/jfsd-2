package com.example.userservice.service;

import com.example.userservice.sahred.UserRequestModel;
import com.example.userservice.sahred.UserResponseModel;

import java.util.Optional;

public interface UserService {
    public UserResponseModel createNewUser(UserRequestModel userRequestModel);

}

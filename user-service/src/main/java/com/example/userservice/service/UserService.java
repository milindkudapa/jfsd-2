package com.example.userservice.service;

import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.model.User;
import com.example.userservice.sahred.UserRequestModel;
import com.example.userservice.sahred.UserResponseModel;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public UserResponseModel createNewUser(UserRequestModel userRequestModel);
    public List<UserResponseModel> getAllUsers();
    public User findUserById(String userId) ;

}

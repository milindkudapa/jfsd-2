package com.example.userservice.controller;

import com.example.userservice.sahred.UserRequestModel;
import com.example.userservice.sahred.UserResponseModel;
import com.example.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/users")
    public ResponseEntity<UserResponseModel> createUser(@RequestBody UserRequestModel userRequestModel)
    {
        return new ResponseEntity<UserResponseModel>(userService.createNewUser(userRequestModel), HttpStatus.CREATED);
    }
}

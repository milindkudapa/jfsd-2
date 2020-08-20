package com.example.userservice.sahred;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestModel {
    @JsonIgnore
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}

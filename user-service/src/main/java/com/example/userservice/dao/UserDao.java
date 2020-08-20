package com.example.userservice.dao;

import com.example.userservice.model.User;
import com.example.userservice.sahred.UserResponseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    public User findByUserId(String userId);

}

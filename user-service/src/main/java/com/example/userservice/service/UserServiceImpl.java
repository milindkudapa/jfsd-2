package com.example.userservice.service;

import com.example.userservice.dao.UserDao;
import com.example.userservice.model.User;
import com.example.userservice.sahred.UserRequestModel;
import com.example.userservice.sahred.UserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl  implements UserService{
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public UserResponseModel createNewUser(UserRequestModel userRequestModel) {
        String str=UUID.randomUUID().toString();
        String str1[]=str.split("-");
        userRequestModel.setUserId(str1[0]);
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        User user=userDao.save(mapper.map(userRequestModel,User.class));
        return mapper.map(user,UserResponseModel.class);

    }
}

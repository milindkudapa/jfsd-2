package com.example.userservice.service;

import com.example.userservice.dao.UserDao;
import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.model.User;
import com.example.userservice.sahred.UserRequestModel;
import com.example.userservice.sahred.UserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl  implements UserService{
    private UserDao userDao;

    private ModelMapper modelMapper;

    public UserServiceImpl(UserDao userDao, ModelMapper modelMapper) {
        this.userDao = userDao;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public UserResponseModel createNewUser(UserRequestModel userRequestModel) {
        String str=UUID.randomUUID().toString();
        String str1[]=str.split("-");
        userRequestModel.setUserId(str1[0]);

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        User user=userDao.save(modelMapper.map(userRequestModel,User.class));
        return modelMapper.map(user,UserResponseModel.class);

    }

    @Override
    @Transactional
    public List<UserResponseModel> getAllUsers() {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<List<UserResponseModel>>(){}.getType();
        List<UserResponseModel> postDtoList = modelMapper.map(userDao.findAll(),listType);
        return postDtoList;
    }

    @Override
    @Transactional
    public User findUserById(String userId) {
        User user=userDao.findByUserId(userId);

       return user;
    }
}

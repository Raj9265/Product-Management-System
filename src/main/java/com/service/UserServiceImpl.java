package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.model.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

   
    public void register(User user) {
        userDao.register(user);
    }

  
    public User validateUser(String username, String password) {
        return userDao.validateUser(username, password);
    }
}

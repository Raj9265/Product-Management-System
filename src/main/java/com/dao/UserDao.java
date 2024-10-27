package com.dao;

import com.model.User;

public interface UserDao {
    void register(User user);
    User validateUser(String username, String password);
}

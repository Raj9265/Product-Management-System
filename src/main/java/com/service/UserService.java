package com.service;

import com.model.User;

public interface UserService {
    void register(User user);
    User validateUser(String username, String password);
}

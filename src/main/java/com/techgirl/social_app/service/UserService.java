package com.techgirl.social_app.service;

import com.techgirl.social_app.model.User;

public interface UserService {
    User findByUsername(String email);
    User saveUser(User user);
}


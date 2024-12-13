package com.techgirl.social_app.service;

import com.techgirl.social_app.model.User;
import com.techgirl.social_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User saveUser(User userDto) {
        User user = new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(user);
    }
}

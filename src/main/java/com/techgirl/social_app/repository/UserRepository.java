package com.techgirl.social_app.repository;

import com.techgirl.social_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User save(User userDto);
}

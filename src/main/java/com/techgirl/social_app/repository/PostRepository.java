package com.techgirl.social_app.repository;

import com.techgirl.social_app.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}

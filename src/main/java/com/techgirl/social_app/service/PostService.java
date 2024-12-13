package com.techgirl.social_app.service;

import com.techgirl.social_app.model.Post;
import com.techgirl.social_app.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void save(Post post) {
        post.setCreatedAt(LocalDateTime.now());
        postRepository.save(post);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }
}

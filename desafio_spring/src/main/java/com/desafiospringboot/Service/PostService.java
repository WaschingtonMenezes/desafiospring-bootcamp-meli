package com.desafiospringboot.Service;

import com.desafiospringboot.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private PostRepository postRepository;

    @Autowired
    PostService(PostRepository repository) {
        postRepository = repository;
    }
}

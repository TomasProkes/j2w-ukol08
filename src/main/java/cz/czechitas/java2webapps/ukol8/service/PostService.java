package cz.czechitas.java2webapps.ukol8.service;

import cz.czechitas.java2webapps.ukol8.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for handling blog posts
 */
@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
}

package cz.czechitas.java2webapps.ukol8.service;

import cz.czechitas.java2webapps.ukol8.entity.Post;
import cz.czechitas.java2webapps.ukol8.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    /**
     * Returns a pageable list of all posts in the database
     */
    public Page<Post> list(Pageable pageable) {
        return postRepository.findPublishedPosts(pageable);
    }

    /**
     * Returns a post based on the post's slug
     *
     * @param slug a unique value in blog posts
     * @return a single post, or null if not available
     */
    public Post singlePost(String slug) {
        return postRepository.findBySlug(slug);
    }
}

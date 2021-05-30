package cz.czechitas.java2webapps.ukol8.repository;

import cz.czechitas.java2webapps.ukol8.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository for table {@code Post}
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    /**
     * Search all posts and return that one that contains a specific slug
     */
    @Query("SELECT p FROM Post p WHERE p.slug = :postSlug")
    Post findBySlug(String postSlug);
}

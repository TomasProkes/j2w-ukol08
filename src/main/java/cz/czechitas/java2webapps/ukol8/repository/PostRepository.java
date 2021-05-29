package cz.czechitas.java2webapps.ukol8.repository;

import cz.czechitas.java2webapps.ukol8.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for table {@code Post}
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    /**
     * Search methods will be added here
     */
}

package cz.czechitas.java2webapps.ukol8.repository;

import cz.czechitas.java2webapps.ukol8.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

/**
 * Repository for table {@code Post}
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    Pageable postList = PageRequest.of(0, 20, Sort.by("published").descending());

    /**
     * Search all posts and return that one that contains a specific slug
     */
    @Query("SELECT p FROM Post p WHERE p.slug = :postSlug")
    Post findBySlug(String postSlug);

    /**
     * Return posts with non-null published date that is not in future and sort them in descending order by publication
     */
    @Query("SELECT p FROM Post p WHERE p.published IS NOT NULL AND p.published <= CURRENT_DATE ORDER BY p.published DESC")
    Page<Post> findPublishedPosts(Pageable postList);
}

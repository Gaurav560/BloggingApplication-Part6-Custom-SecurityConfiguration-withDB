package com.telusko.repo;

import com.telusko.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Integer> {
    @Query(value = "SELECT * FROM blog b WHERE " +
            "LOWER(b.blog_title) LIKE LOWER(CONCAT('%', :text, '%')) OR " +
            "LOWER(b.author_name) LIKE LOWER(CONCAT('%', :text, '%')) OR " +
            "LOWER(b.category) LIKE LOWER(CONCAT('%', :text, '%')) OR " +
            "LOWER(b.content) LIKE LOWER(CONCAT('%', :text, '%'))", nativeQuery = true)
    List<Blog> searchBlogs(@Param("text") String text);
}

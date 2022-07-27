package com.blogApp.blog.repositories;

import com.blogApp.blog.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
    List<Post> findByTitleContaining(String title);

    @Query("select p from Post p where content like :key")
    List<Post> searchByContent(@Param("key")String content);
}

package com.telusko.service;

import com.telusko.model.Blog;
import com.telusko.repo.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepo blogRepo;

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepo.findAll();
    }

    @Override
    public Blog getBlogById(int id) {
        return blogRepo.findById(id).orElseThrow(() -> new RuntimeException("Blog not found with id " + id));
    }

    @Override
    public Blog addBlog(Blog blog) {
        return blogRepo.save(blog);
    }

    @Override
    public Blog updateBlog(int id, Blog blog) {
        Blog existingBlog = blogRepo.findById(id).orElseThrow(() -> new RuntimeException("Blog not found with id " + id));
        existingBlog.setBlogTitle(blog.getBlogTitle());
        existingBlog.setContent(blog.getContent());
        existingBlog.setAuthorName(blog.getAuthorName());
        existingBlog.setCategory(blog.getCategory());
        return blogRepo.save(existingBlog);
    }

    @Override
    public void deleteBlog(int id) {
        Blog existingBlog = blogRepo.findById(id).orElseThrow(() -> new RuntimeException("Blog not found with id " + id));
        blogRepo.delete(existingBlog);
    }

    @Override
    public List<Blog> searchBlogs(String text) {
        return blogRepo.searchBlogs(text);
    }

}

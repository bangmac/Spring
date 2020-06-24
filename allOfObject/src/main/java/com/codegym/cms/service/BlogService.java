package com.codegym.cms.service;

import com.codegym.cms.model.Blog;

public interface BlogService {
    Iterable<Blog> findAll();

    Blog findById(Long id);

    Blog save(Blog blog);

    void remove(Long id);
}

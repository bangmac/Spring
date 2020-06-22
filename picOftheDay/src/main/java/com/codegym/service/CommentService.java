package com.codegym.service;

import com.codegym.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> showAllComment();

    Comment addComment(Comment comment);

    void addLike(Comment comment);

    void dissLike(Comment comment);

    Comment findOne(Long id);
}

package com.codegym.service;

import com.codegym.exception.BadWordException;
import com.codegym.model.Comment;
import com.codegym.repository.CommentRepository;
import com.codegym.repository.CommentRepositoryQuery;
import com.codegym.service.CommentService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class CommentServiceImpl implements CommentService {

    private static List<String> badWordList;

    static {
        badWordList = new ArrayList<String>();
        badWordList.add("penis");
        badWordList.add("vagina");
        badWordList.add("pussy");
        badWordList.add("bitch");
        badWordList.add("nigger");
        badWordList.add("mẹ");
        badWordList.add("buồi");
        badWordList.add("lồn");
    }

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentRepositoryQuery commentRepositoryQuery;


    @Override
    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findOne(id);
    }

    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.delete(id);
    }

    @Override
    public Iterable<Comment> allTodayComments() {
        return commentRepositoryQuery.allTodayComments();
    }

    @Override
    public void like(Comment comment) {
        int likeNumber = comment.getLikes() + 1;
        comment.setLikes(likeNumber);
        commentRepository.save(comment);
    }

    @Override
    public void disLike(Comment comment) {
        comment.setLikes(comment.getLikes() - 1);
        commentRepository.save(comment);
    }

    @Override
    public void checkBadWord(Comment comment) throws BadWordException {
        for (String word : badWordList) {
            if (comment.getFeedback().toLowerCase().contains(word)) {
                throw new BadWordException();
            }
        }
    }
}

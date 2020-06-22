package com.codegym.controller;

import com.codegym.model.Comment;
import com.codegym.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

//    @GetMapping("/start")
//    public String showHome( ) {
//        return "/home";
//    }

    @GetMapping("/start")
    public ModelAndView showHome() {
        ModelAndView modelAndView = new ModelAndView("/home");
        List<Comment> comments = commentService.showAllComment();
        modelAndView.addObject("comments", comments);
        return modelAndView;
    }

    @GetMapping("/saveComment")
    public String addComment(Comment comment) {
        commentService.addComment(comment);
        return "redirect:/start";
    }

    @GetMapping("/likeComment/{id}")
    public String like(@PathVariable Long id){
        Comment comment=commentService.findOne(id);
        commentService.addLike(comment);
        return "redirect:/start";
    }

    @GetMapping("/dislikeComment/{id}")
    public String dislike(@PathVariable Long id){
        Comment comment=commentService.findOne(id);
        commentService.dissLike(comment);
        return "redirect:/start";
    }
}

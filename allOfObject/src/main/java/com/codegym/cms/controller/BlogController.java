package com.codegym.cms.controller;

import com.codegym.cms.model.Blog;
import com.codegym.cms.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/homepage")
    public ModelAndView showAllBlog() {
        ModelAndView modelAndView = new ModelAndView("blog/blogList");
        Iterable<Blog> list = blogService.findAll();
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @GetMapping("/addBlog")
    public ModelAndView addBlog() {
        ModelAndView modelAndView = new ModelAndView("blog/add");
//        Iterable<Blog> list = blogService.findAll();
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/addBlog")
    public String addNewBlog(Blog blog) {
        blogService.save(blog);
        return "redirect:/homepage";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("blog/detail");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("blog/delete");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteBlog(@ModelAttribute("blog") Blog blog) {
        blogService.remove(blog.getId());
        return "redirect:/homepage";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("blog/edit");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        return "redirect:/homepage";
    }

}

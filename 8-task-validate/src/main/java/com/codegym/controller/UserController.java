package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.validator.PhoneNumValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @GetMapping("/start")
    ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/form");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/validate")
    public String checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        new PhoneNumValidator().validate(user.getPhoneNum(),bindingResult);
        if (bindingResult.hasFieldErrors())
            return "/form";
        else {
            return "/result";
        }
    }


}

package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.codegym.model.PhoneNumber;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PhoneController {
//    @GetMapping("/showform")
//    public String showForm(Model model){
//        model.addAttribute("phonemunber", new PhoneNumber());
//        return "index";
//    }
//
//    @PostMapping("/phone")
//    public String checkValidation (@Valid @ModelAttribute("phonemunber")PhoneNumber phoneNumber, BindingResult bindingResult, Model model){
//        new PhoneNumber().validate(phoneNumber, bindingResult);
//        if (bindingResult.hasFieldErrors()){
//            return "index";
//        }
//        else {
//            model.addAttribute("phoneNumber", phoneNumber.getNumber());
//            return "result";
//        }
//    }

    @GetMapping("showform")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("phonemunber", new PhoneNumber());
        return modelAndView;
    }

    @PostMapping("phone")
    public ModelAndView checkValidation (@Valid @ModelAttribute("phonemunber")PhoneNumber phoneNumber, BindingResult bindingResult){
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("index");
            return modelAndView;
        }
        else {
            ModelAndView modelAndView = new ModelAndView("result");
            modelAndView.addObject("phoneNumber", phoneNumber.getNumber());
            return modelAndView;
        }
    }
}

package com.codegym.controller;

import com.codegym.model.MyCounter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("mycounter")
// @SessionAttributes("mycounter") này đc dùng để lưu @ModelAttribute có cùng tên vào trong session
public class CounterController {
    @ModelAttribute("mycounter")
    // tên của @ModelAttribute phải trùng với tên của @SessionAttributes là "mycounter"
    // thì @ModelAttribute mới được thêm vào trong session
    public MyCounter setUpCounter(){
        return new MyCounter();
    }

    @GetMapping("/")
    public String getCountViews(@ModelAttribute("mycounter") MyCounter myCounter){
        myCounter.increment();
        return "index";
    }
}

package com.learningspringboot.springbootlearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("/helloni")
    public void hello(@RequestParam(name = "name") String name, Model model){
        model.addAttribute("name",name);
        //return "asdas";
    }
}

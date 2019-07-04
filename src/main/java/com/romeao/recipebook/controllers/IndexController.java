package com.romeao.recipebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "/index"})
    public String redirectToRecipes() {
        return "redirect:/recipes";
    }
}

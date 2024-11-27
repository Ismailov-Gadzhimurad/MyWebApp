package com.example.example.controllers;

import com.example.example.repo.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private TransferRepository transferRepository;

    @GetMapping("/")
    public String home(Model model) {


        model.addAttribute("title", "Главная страница");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {


        model.addAttribute("title", "Страница  про нас");
        return "about";

    }
}
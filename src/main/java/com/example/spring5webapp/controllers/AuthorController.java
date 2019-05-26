package com.example.spring5webapp.controllers;

import com.example.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    AuthorRepository authorRepository;

    //Spring will autowire AuthorRepository
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        String key = "authors";

        //Add list of the books from authorRepository with the defined key
        model.addAttribute(key, authorRepository.findAll());

        //return the key to access books data
        return key;
    }
}

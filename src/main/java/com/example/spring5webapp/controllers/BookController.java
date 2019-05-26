package com.example.spring5webapp.controllers;

import com.example.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepository bookRepository;

    //Spring will autowire BookRepository
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Spring will pass Model to this method
    @RequestMapping("/books")
    public String getBooks(Model model){
        String key ="books";

        //Add list of the books from bookRepository with the defined key
        model.addAttribute(key, bookRepository.findAll());

        //return the key to access books data
        return key;
    }
}

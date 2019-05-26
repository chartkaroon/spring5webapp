package com.example.spring5webapp.bootstrap;

import com.example.spring5webapp.model.Author;
import com.example.spring5webapp.model.Book;
import com.example.spring5webapp.model.Publisher;
import com.example.spring5webapp.repositories.AuthorRepository;
import com.example.spring5webapp.repositories.BookRepository;
import com.example.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Publishers
        Publisher publisher1 = new Publisher("Harper Collins", "Addr 1");
        Publisher publisher2 = new Publisher("Worx", "Addr 2");
        publisherRepository.save(publisher1);
        publisherRepository.save(publisher2);

        //Eric
        Author author1 = new Author("Eric","Evans");
        Book book1 = new Book("Domain Driven Design", "1234", publisher1);
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        book1.setPublisher(publisher1);
        authorRepository.save(author1);
        bookRepository.save(book1);

        //Rod
        Author author2 = new Author("Rod","Johnson");
        Book book2 = new Book("J2EE Development without EJB", "23444", publisher2);
        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);
        book2.setPublisher(publisher2);
        authorRepository.save(author2);
        bookRepository.save(book2);

    }

}

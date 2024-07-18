package com.pabloquiroga.essentials.books;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class BooksService {
    private final BooksRepository repository;

    public BooksService(BooksRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAll(){
        return repository.listAll();
    }

    public void create(Book book){
        repository.persist(book);
    }
}

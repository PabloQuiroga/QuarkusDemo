package com.pabloquiroga.essentials.books;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Transactional
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

    public Optional<Book> getById(Long id){
        return Optional.of(repository.findById(id));
    }

    public Boolean deleteById(Long id){
        return repository.deleteById(id);
    }
}

package com.programacion.services;

import com.programacion.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();
    Book findById(Integer id);
    void insert(Book book);
    void update(Book book, Integer id);
    void delete(Integer id);

}

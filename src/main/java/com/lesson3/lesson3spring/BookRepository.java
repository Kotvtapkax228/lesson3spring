package com.lesson3.lesson3spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookItem, Long> {
    List<BookItem> findByAuthorAndTitleAndGenre(String author, String title, String gennre);
    List<BookItem> findByAuthorAndTitle(String author, String title);
    List<BookItem> findByAuthor(String author);
    List<BookItem> findByTitle(String title);
    List<BookItem> findAll();
}

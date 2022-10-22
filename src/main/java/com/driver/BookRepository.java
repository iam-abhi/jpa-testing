package com.driver;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query("select b from Book b where b.id = :id")
    Book findBookById(int id);

    @Modifying
    @Query("delete from Book b where b.id = :id")
    void deleteBookById(int id);

    @Query("select b from Book b where b.author = :author")
    List<Book> findBooksByAuthor(String author);

    @Query("select b from Book b where b.genre = :genre")
    List<Book> findBooksByGenre(String genre);
}

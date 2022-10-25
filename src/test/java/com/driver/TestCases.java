package com.driver;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class)
// @DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// @ContextConfiguration(locations = "/applicationContext.xml")
public class TestCases {

    @Autowired
    // @Qualifier("bookTestImpl")
    BookRepository bookRepository;

    @Test
    @Order(1)
    public void saveBook(){
        Book book = new Book("Book1", "Genre1", "Author1");
        bookRepository.save(book);
        System.out.println(book.getId());

        Assertions.assertThat(book.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void saveBook2(){
        List<Book> book1 = bookRepository.findBooksByGenre("Genre1");
        System.out.println(book1.size());

        org.junit.jupiter.api.Assertions.assertEquals(book1.size(), 1);
    }

    @Test
    @Order(3)
    public void saveBook3(){
        Book book = new Book("Book2", "Genre1", "Author2");
        bookRepository.save(book);

        List<Book> book1 = bookRepository.findBooksByAuthor("Author2");
        System.out.println(book1.size());

        org.junit.jupiter.api.Assertions.assertEquals(book1.size(), 1);
    }

    @Test
    @Order(4)
    public void saveBook4(){
        List<Book> book1 = bookRepository.findBooksByGenre("Genre1");
        System.out.println(book1.size());

        org.junit.jupiter.api.Assertions.assertEquals(book1.size(), 2);
    }

}

package com.example.library_management.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library_management.Model.Book;
import com.example.library_management.Repository.BookRepo;

@Service
public class BookService {
    @Autowired
    private BookRepo br;

    // Book Entry..
    public void bsave(Book book) {
        br.save(book);
    }

    // Book View..
    public List<Book> getAllBooks() {
        return br.findAll();
    }

    // Book Update..
    public Book getBookById(int id) {
        Optional<Book> optional = br.findById(id);
        Book book = null;
        if (optional.isPresent())
            book = optional.get();
        else
            throw new RuntimeException(
                    "Employee not found for id : " + id);
        return book;
    }

    // Book Delete..
    public void deleteBookById(int id) {
        br.deleteById(id);
    }

}

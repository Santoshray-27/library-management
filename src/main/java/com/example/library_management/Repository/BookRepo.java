package com.example.library_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library_management.Model.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

    
}

package com.example.library_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library_management.Model.Faculty;

public interface FacultyRepo extends JpaRepository<Faculty, Integer> {

    
}

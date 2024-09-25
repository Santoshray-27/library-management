package com.example.library_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library_management.Model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    
}

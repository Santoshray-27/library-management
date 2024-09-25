package com.example.library_management.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library_management.Model.Customer;
import com.example.library_management.Repository.CustomerRepo;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo cr;

    // Customer Entry..
    public void csave(Customer customer) {
        cr.save(customer);
    }

    // Customer View..
    public java.util.List<Customer> getAllCustomers() {
        return cr.findAll();
    }

    // Customer Update..
    public Customer getCustomerById(int id) {
        Optional<Customer> optional = cr.findById(id);
        Customer customer = null;
        if (optional.isPresent())
            customer = optional.get();
        else
            throw new RuntimeException(
                    "Customer not found for id : " + id);
        return customer;
    }

    // Customer Delete..
    public void deleteCustomerById(int id) {
        cr.deleteById(id);
    }

}

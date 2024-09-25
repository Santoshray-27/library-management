package com.example.library_management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.library_management.Model.Book;
import com.example.library_management.Model.Customer;
import com.example.library_management.Model.Faculty;
import com.example.library_management.Service.BookService;
import com.example.library_management.Service.CustomerService;
import com.example.library_management.Service.FacultyService;

@Controller
public class AdminCon {
    
    @Autowired
    private BookService bs;
    @Autowired
    private CustomerService cs;
    @Autowired
    private FacultyService fs;

    // Open Admin Page..
    @GetMapping("/admin")
    public String home() {
        return "/Admin/Admin";
    }

    // Detail Of Book's....

    // Detail Of Customer's....
    @GetMapping("/admin/customerview")
    public String customerView(Model model) {
        model.addAttribute("customers", cs.getAllCustomers());
        return "/Admin/CustomerView";
    }

    // Detail Of Faculty's....
    @GetMapping("/admin/facultyview")
    public String facultyView(Model model) {
        model.addAttribute("faculties", fs.getAllFacultys());
        return "/Admin/FacultyView";
    }

    // Update Book
    @GetMapping("/showFormForUpdateBook/{id}")
    public String updateBookForm(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("book", bs.getBookById(id));
        return "/Update/BookUpdate";
    }

    // Save Book
    @PostMapping("/bupsave")
    public String bsave(@ModelAttribute("book") Book book) {
        bs.bsave(book);
        return "redirect:/admin/bookview";
    }

    // Update Customer
    @GetMapping("/showFormForUpdate/{id}")
    public String updateCustomerForm(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("customer", cs.getCustomerById(id));
        return "/Update/CustomerUpdate";
    }

    // Save Customer
    @PostMapping("/cupsave")
    public String csave(@ModelAttribute("customer") Customer customer) {
        cs.csave(customer);
        return "redirect:/admin/customerview";
    }

    // Update Faculty
    @GetMapping("/showFormForUpdateFaculty/{id}")
    public String updateFacultyForm(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("faculty", fs.getFacultyById(id));
        return "/Update/FacultyUpdate";
    }

    // Save Faculty
    @PostMapping("/fupsave")
    public String fsave(@ModelAttribute("faculty") Faculty faculty) {
        fs.fsave(faculty);
        return "redirect:/admin/facultyview";
    }

    // Delete Book
    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable(value = "id") int id) {
        bs.deleteBookById(id);
        return "redirect:/admin/bookview";
    }

    // Delete Customer
    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int id) {
        cs.deleteCustomerById(id);
        return "redirect:/admin/customerview";
    }

    // Delete Faculty
    @GetMapping("/deleteFaculty/{id}")
    public String deleteFaculty(@PathVariable(value = "id") int id) {
        fs.deleteFacultyById(id);
        return "redirect:/admin/facultyview";
    }
}
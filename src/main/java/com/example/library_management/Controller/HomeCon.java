package com.example.library_management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.library_management.Model.Book;
import com.example.library_management.Model.Customer;
import com.example.library_management.Model.Faculty;
import com.example.library_management.Service.BookService;
import com.example.library_management.Service.CustomerService;
import com.example.library_management.Service.FacultyService;

@Controller
public class HomeCon {

    @Autowired
    private BookService bs;
    @Autowired
    private CustomerService cs;
    @Autowired
    private FacultyService fs;

    @GetMapping("/")
    public String home() {
        return "/Home/home";
    }

    // For Book Entry...

    @GetMapping("/home/bookentry")
    public String savebookEntry(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "/Home/BookEntry";
    }

    // Save Detail...

    @PostMapping("/bsave")
    public String bsave(@ModelAttribute("book") Book book) {
        bs.bsave(book);
        return "redirect:/";
    }

    // For Customer Entry...

    @GetMapping("/home/customerentry")
    public String savecustomerEntry(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "/Home/CustomerEntry";
    }

    // Save Detail...

    @PostMapping("/csave")
    public String csave(@ModelAttribute("customer") Customer customer) {
        cs.csave(customer);
        return "redirect:/";
    }

    // For Faculty Entry...

    @GetMapping("/home/facultyentry")
    public String saveFacultyEntry(Model model) {
        Faculty faculty = new Faculty();
        model.addAttribute("faculty", faculty);
        return "/Home/FacultyEntry";
    }

    // Save Detail...

    @PostMapping("/fsave")
    public String fsave(@ModelAttribute("faculty") Faculty faculty) {
        fs.fsave(faculty);
        return "redirect:/";
    }
}

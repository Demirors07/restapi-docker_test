package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Controller
public class HomeController {
    
    private final CustomerRepository customerRepository;

    public HomeController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

   /*  @GetMapping("/")
    public String getIndex() {
        return "<b>SWE 304 PROJECT STUDY 1</b>";
    } */

    @GetMapping("/customer")
    public String getCustomers(Model model) {
        Iterable<Customer> customerList = customerRepository.findAll();
        model.addAttribute("customerList", customerList);
        return "customer/index";
    }
}

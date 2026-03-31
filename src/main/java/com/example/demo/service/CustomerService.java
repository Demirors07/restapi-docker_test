package com.example.demo.service;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.model.Customer;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.LoanDTO;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepo;
    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public CustomerDTO createCustomer(CustomerDTO request) {
        Customer customer = new Customer();

        customer.setName(request.getName());
        customer.setAddress(request.getAddress());
        customer.setCity(request.getCity());

        Customer saved = customerRepo.save(customer);

        return mapToDTO(saved);
    }

    public List<CustomerDTO> getAllCustomers(){
        List<Customer> customers = customerRepo.findAll();

        return customers.stream()
        .map(this::mapToDTO)
        .collect(Collectors.toList());
    }

    public CustomerDTO getOneCustomer(Long id){
        Customer customer = customerRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Customer not found"));
        return mapToDTO(customer);
    }

    public CustomerDTO update(Long id, CustomerDTO request) {
        Customer customer = customerRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.setName(request.getName());
        customer.setAddress(request.getAddress());
        customer.setCity(request.getCity());

        Customer updated = customerRepo.save(customer);

        return mapToDTO(updated);
    }

    public void deleteCustomer(Long id) {
        if(!customerRepo.existsById(id)) {
            throw new RuntimeException("Customer not found");
        }
        customerRepo.deleteById(id);
    }



    private CustomerDTO mapToDTO(Customer customer) {

        List<LoanDTO> loanDTOs = customer.getLoans() == null
        ? List.of()
        : customer.getLoans()
        .stream()
        .map(loan -> new LoanDTO(
            loan.getId(),
            loan.getDate(),
            loan.getAmount(),
            loan.getAccount().getId(),
            loan.getCustomer().getId()
        ))
        .collect(Collectors.toList());

        return new CustomerDTO(
            customer.getId(),
            customer.getName(),
            customer.getAddress(),
            customer.getCity(),
            loanDTOs
        );
    }

}
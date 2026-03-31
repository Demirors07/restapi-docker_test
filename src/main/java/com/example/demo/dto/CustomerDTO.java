package com.example.demo.dto;

import java.util.List;


public class CustomerDTO {
    private Long id;

    private String name;
    private String address;
    private String city;

    private List<LoanDTO> loans;

    // JPA için boş constructor
    public CustomerDTO() {
    }

    // Full constructor
    public CustomerDTO(Long id, String name, String address, String city, List<LoanDTO> loans) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.loans = loans;
    }

    // Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<LoanDTO> getLoans() {
        return loans;
    }

    public void setLoans(List<LoanDTO> loans) {
        this.loans = loans;
    }
}
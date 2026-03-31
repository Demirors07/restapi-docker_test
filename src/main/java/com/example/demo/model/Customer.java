package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 16)
    private String name;

    @Column(length = 32)
    private String address;

    @Column(length = 16)
    private String city;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Loan> loans;

    // JPA için boş constructor
    public Customer() {
    }

    // Full constructor
    public Customer(Long id, String name, String address, String city, List<Loan> loans) {
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

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
}

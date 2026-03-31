package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 16)
    private String name;

    @Column(precision = 15, scale = 2)
    private BigDecimal balance;

    @OneToMany(mappedBy = "account")
    private List<Loan> loans;

    // JPA boş constructor
    public Account() {
    }

    // Full constructor
    public Account(Long id, String name, BigDecimal balance, List<Loan> loans) {
        this.id = id;
        this.name = name;
        this.balance = balance;
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
}

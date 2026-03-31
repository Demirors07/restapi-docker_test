package com.example.demo.dto;

import java.math.BigDecimal;
import java.util.List;

public class AccountDTO {
    private Long id;

    private String name;
    private BigDecimal balance;

    private List<LoanDTO> loans;

    // JPA boş constructor
    public AccountDTO() {
    }

    // Full constructor
    public AccountDTO(Long id, String name, BigDecimal balance, List<LoanDTO> loans) {
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

    public List<LoanDTO> getLoans() {
        return loans;
    }

    public void setLoans(List<LoanDTO> loans) {
        this.loans = loans;
    }
}
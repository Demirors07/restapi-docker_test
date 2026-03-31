package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanDTO {
    private Long id;

    private LocalDate date;
    private BigDecimal amount;
    private Long accountId;
    private Long customerId;

    // JPA boş constructor
    public LoanDTO() {
    }

    // Full constructor
    public LoanDTO(Long id, LocalDate date, BigDecimal amount, Long customerId, Long accountId) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.customerId = customerId;
        this.accountId = accountId;
    }

    // Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomer(Long customerId) {
        this.customerId = customerId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
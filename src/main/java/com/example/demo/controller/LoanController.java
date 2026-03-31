package com.example.demo.controller;

import com.example.demo.dto.LoanDTO;
import com.example.demo.service.LoanService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService){
        this.loanService = loanService;
    }

    @PostMapping
    public LoanDTO create(@RequestBody LoanDTO request) {
        return loanService.createLoan(request);
    }

    @GetMapping
    public List<LoanDTO> getAll() {
        return loanService.getAllLoans();
    }

    @GetMapping("/{id}")
    public LoanDTO getOne(@PathVariable Long id) {
        return loanService.getOneLoan(id);
    }

    @PutMapping("/{id}")
    public LoanDTO update(@PathVariable Long id, @RequestBody LoanDTO request) {
        return loanService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        loanService.deleteLoan(id);
    }

}
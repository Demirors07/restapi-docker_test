package com.example.demo.service;

import com.example.demo.repository.AccountRepository;
import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.LoanDTO;
import com.example.demo.model.Account;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
    private final AccountRepository accountRepo;

    public AccountService(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }


    public AccountDTO createAccount(AccountDTO request) {
        Account account = new Account();
        account.setName(request.getName());
        account.setBalance(request.getBalance());

        Account saved = accountRepo.save(account);
        return mapToDTO(saved);
    }

    public List<AccountDTO> getAllAccounts() {
        List<Account> accounts = accountRepo.findAll();

        return accounts.stream()
        .map(this::mapToDTO)
        .collect(Collectors.toList());
    }

    public AccountDTO getOne(Long id) {
        Account account = accountRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Customer not found"));

        return mapToDTO(account);
    }

    public AccountDTO updateAccount(Long id, AccountDTO request) {
        Account account = accountRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Account not found"));
        account.setName(request.getName());
        account.setBalance(request.getBalance());

        Account updated = accountRepo.save(account);
        
        return mapToDTO(updated);
    }

    public void deleteAccount(Long id) {
        if (!accountRepo.existsById(id)) {
            throw new RuntimeException("Account not found");
        }

        accountRepo.deleteById(id);
    }



    private AccountDTO mapToDTO(Account account) {

    List<LoanDTO> loanDTOs = account.getLoans() == null
            ? List.of()
            : account.getLoans()
                .stream()
                .map(loan -> new LoanDTO(
                        loan.getId(),
                        loan.getDate(),
                        loan.getAmount(),
                        loan.getAccount().getId(),
                        loan.getCustomer().getId()
                ))
                .collect(Collectors.toList());

    return new AccountDTO(
            account.getId(),
            account.getName(),
            account.getBalance(),
            loanDTOs
        );
    }
}
package com.spring.rest.services;

import com.spring.rest.models.Account;
import com.spring.rest.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    @Autowired
    private final AccountRepository accountRepository;

    public void createAccount(Account account){
        accountRepository.save(account);
    }

    public Optional<Account> findById(Long id){
        return accountRepository.findById(id);
    }

    public List<Account> findAllAccount(){
        return (List<Account>) accountRepository.findAll();
    };

    public void deleteAccount(Long id){
        accountRepository.deleteById(id);
    }

    public void save(Account account){accountRepository.save(account);};

}

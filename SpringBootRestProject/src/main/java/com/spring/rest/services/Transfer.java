package com.spring.rest.services;

import com.spring.rest.models.Account;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Transfer {
    long accountNumberReceiver;
    long value;

    AccountService accountService;

    public Account send(Account account, double value){
        if(account.getBalance()<value) throw new RuntimeException("insufficiently founds");
        account.setBalance(account.getBalance()-value);
        return account;
    }

    public Account receive(Account account, double value){
        account.setBalance(account.getBalance()+value);
        return account;
    }
}

package com.spring.rest.controllers;

import com.spring.rest.controllers.DTO.ClientDTO;
import com.spring.rest.models.Account;
import com.spring.rest.models.Client;
import com.spring.rest.services.AccountService;
import com.spring.rest.services.ClientService;
import com.spring.rest.services.Transfer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/client/account")
@RequiredArgsConstructor
public class AccountController {

    @Autowired
    private final AccountService accountService;
    ClientController clientController;
    ClientService clientService;

    @PostMapping("/createAccount")
    public ResponseEntity<?> createAccount(@RequestBody Client client){
        Account account = Account.builder().accountNumber(client.getCc()).balance(1000).client(client).build();
        accountService.createAccount(account);
        return ResponseEntity.ok("account has been created");
    }

    @GetMapping("/getAccountById/{id}")
    public ResponseEntity<?> getAccount(@PathVariable long id){
        Optional<Account> accountOptional =  accountService.findById(id);
        return ResponseEntity.ok(accountOptional);
    }

    @DeleteMapping("/deleteAccountById/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("account has been deleted");
    }

    @PutMapping("/transfer/{id}")
    public ResponseEntity<?> transfer(@PathVariable long id, @RequestBody Transfer transfer) {
        Optional<Account> accountOptionalOwn = accountService.findById(id);
        Optional<Account> accountOptionalReceiver = accountService.findById(transfer.getAccountNumberReceiver());
        if(accountOptionalOwn.isPresent() && accountOptionalReceiver.isPresent()) {
            Account account = accountOptionalOwn.get();
            Account accountReceiver = accountOptionalReceiver.get();
            transfer.send(account, transfer.getValue());
            transfer.receive(accountReceiver, transfer.getValue());
            accountService.save(account);
            accountService.save(accountReceiver);
            return ResponseEntity.ok("transfer has been made");
        }
        return ResponseEntity.notFound().build();
    }



}

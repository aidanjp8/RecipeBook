package com.cookbook.book.controller;

import com.cookbook.book.model.Account;
import com.cookbook.book.model.Recipe;
import com.cookbook.book.service.AccountService;
import com.cookbook.book.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;


    @PostMapping("/createaccount")
    public ResponseEntity<String> add(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return ResponseEntity.ok("Account created with ID: " + createdAccount.getId());
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Account>> getAll() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

}

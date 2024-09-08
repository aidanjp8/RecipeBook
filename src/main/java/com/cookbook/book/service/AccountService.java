package com.cookbook.book.service;

import com.cookbook.book.model.Account;
import com.cookbook.book.model.Recipe;

import java.util.List;

public interface AccountService {

    public Account createAccount(Account account);

    public Account addRecipeToAccount(int accountId, Recipe recipe);

    public List<Account> getAllAccounts();
}

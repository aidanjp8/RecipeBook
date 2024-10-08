package com.cookbook.book.service;

import com.cookbook.book.model.Account;
import com.cookbook.book.model.Recipe;
import com.cookbook.book.repository.AccountRepository;
import com.cookbook.book.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account addRecipeToAccount(int accountId, Recipe recipe) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        recipe.setAccount(account);
        Recipe savedRecipe = recipeRepository.save(recipe);

        account.getRecipes().add(savedRecipe);
        accountRepository.save(account);

        return account;
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}

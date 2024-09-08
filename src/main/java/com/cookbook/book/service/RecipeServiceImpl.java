package com.cookbook.book.service;

import com.cookbook.book.model.Account;
import com.cookbook.book.model.Recipe;
import com.cookbook.book.repository.AccountRepository;
import com.cookbook.book.repository.RecipeRepository;
import com.cookbook.book.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    @Transactional
    public Account addRecipeToAccount(int accountId, Recipe recipe) {
        // Find the account by ID
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found with ID: " + accountId));

        // Set the account for the recipe
        recipe.setAccount(account);

        // Save the recipe
        recipeRepository.save(recipe);

        // Add the recipe to the account's list of recipes
        account.getRecipes().add(recipe);

        // Save the updated account
        accountRepository.save(account);

        return account;
    }
}

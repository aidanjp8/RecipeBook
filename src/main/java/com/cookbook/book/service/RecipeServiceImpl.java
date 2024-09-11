package com.cookbook.book.service;

import com.cookbook.book.model.Account;
import com.cookbook.book.model.Recipe;
import com.cookbook.book.repository.AccountRepository;
import com.cookbook.book.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public Recipe addRecipeToAccount(int accountId, Recipe recipe) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        recipe.setAccount(account);
        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> getRecipesByAccountId(int accountId) {
        return recipeRepository.findByAccountId(accountId);
    }

    @Override
    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }

    @Override
    public void updateRecipe(Long id, Recipe recipe) {
        if (recipeRepository.existsById(id)) {
            recipe.setId(id);
            recipeRepository.save(recipe);
        }
    }

    @Override
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }
}

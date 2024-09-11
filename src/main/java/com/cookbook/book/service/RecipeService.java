package com.cookbook.book.service;

import com.cookbook.book.model.Account;
import com.cookbook.book.model.Recipe;
import java.util.List;

public interface RecipeService {
    Recipe addRecipeToAccount(int accountId, Recipe recipe);
    List<Recipe> getRecipesByAccountId(int accountId);
    Recipe getRecipeById(Long id);
    void updateRecipe(Long id, Recipe recipe);
    void deleteRecipe(Long id);
}

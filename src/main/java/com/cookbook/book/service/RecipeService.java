package com.cookbook.book.service;

import com.cookbook.book.model.Account;
import com.cookbook.book.model.Recipe;

public interface RecipeService {

    Account addRecipeToAccount(int accountId, Recipe recipe);
}

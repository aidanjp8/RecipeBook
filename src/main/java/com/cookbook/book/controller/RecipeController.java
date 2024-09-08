package com.cookbook.book.controller;

import com.cookbook.book.model.Account;
import com.cookbook.book.model.Recipe;
import com.cookbook.book.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping("/add/{accountId}")
    public ResponseEntity<String> addRecipeToAccount(@PathVariable int accountId, @RequestBody Recipe recipe) {
        try {
            Account updatedAccount = recipeService.addRecipeToAccount(accountId, recipe);
            return ResponseEntity.ok("Recipe added successfully to account with ID: " + accountId);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}

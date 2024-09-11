package com.cookbook.book.controller;

import com.cookbook.book.model.Account;
import com.cookbook.book.model.Folder;
import com.cookbook.book.model.Recipe;
import com.cookbook.book.service.AccountService;
import com.cookbook.book.service.FolderService;
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

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private FolderService folderService;

    // Account Endpoints
    @PostMapping("/createaccount")
    public ResponseEntity<String> add(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return ResponseEntity.ok("Account created with ID: " + createdAccount.getId());
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Account>> getAll() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    // Recipe Endpoints
    @PostMapping("/addRecipe")
    public ResponseEntity<String> addRecipe(@RequestParam int accountId, @RequestBody Recipe recipe) {
        Recipe createdRecipe = recipeService.addRecipeToAccount(accountId, recipe);
        return ResponseEntity.ok("Recipe created with ID: " + createdRecipe.getId());
    }

    @GetMapping("/getRecipes")
    public ResponseEntity<List<Recipe>> getRecipes(@RequestParam int accountId) {
        return ResponseEntity.ok(recipeService.getRecipesByAccountId(accountId));
    }

    @GetMapping("/getRecipe/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable Long id) {
        return ResponseEntity.ok(recipeService.getRecipeById(id));
    }

    @PutMapping("/updateRecipe/{id}")
    public ResponseEntity<String> updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        recipeService.updateRecipe(id, recipe);
        return ResponseEntity.ok("Recipe updated with ID: " + id);
    }

    @DeleteMapping("/deleteRecipe/{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.ok("Recipe deleted with ID: " + id);
    }

    // Folder Endpoints
    @PostMapping("/addFolder")
    public ResponseEntity<String> addFolder(@RequestBody Folder folder) {
        Folder createdFolder = folderService.createFolder(folder);
        return ResponseEntity.ok("Folder created with ID: " + createdFolder.getId());
    }

    @GetMapping("/getFolders")
    public ResponseEntity<List<Folder>> getFolders(@RequestParam int accountId) {
        return ResponseEntity.ok(folderService.getFoldersByAccountId(accountId));
    }

    @GetMapping("/getFolder/{id}")
    public ResponseEntity<Folder> getFolder(@PathVariable int id) {
        return ResponseEntity.ok(folderService.getFolderById(id));
    }

    @PutMapping("/updateFolder/{id}")
    public ResponseEntity<String> updateFolder(@PathVariable int id, @RequestBody Folder folder) {
        folderService.updateFolder(id, folder);
        return ResponseEntity.ok("Folder updated with ID: " + id);
    }

    @DeleteMapping("/deleteFolder/{id}")
    public ResponseEntity<String> deleteFolder(@PathVariable int id) {
        folderService.deleteFolder(id);
        return ResponseEntity.ok("Folder deleted with ID: " + id);
    }
}

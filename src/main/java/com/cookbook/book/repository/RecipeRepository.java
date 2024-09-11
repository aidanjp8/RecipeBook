package com.cookbook.book.repository;

import com.cookbook.book.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByAccountId(int accountId);
}

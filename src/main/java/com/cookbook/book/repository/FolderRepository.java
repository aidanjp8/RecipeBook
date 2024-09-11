package com.cookbook.book.repository;

import com.cookbook.book.model.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FolderRepository extends JpaRepository<Folder, Integer> {
    List<Folder> findByAccountId(int accountId);
}

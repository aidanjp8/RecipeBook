package com.cookbook.book.service;

import com.cookbook.book.model.Folder;
import java.util.List;

public interface FolderService {
    Folder createFolder(Folder folder);
    List<Folder> getFoldersByAccountId(int accountId);
    Folder getFolderById(int id);
    void updateFolder(int id, Folder folder);
    void deleteFolder(int id);
}

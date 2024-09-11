package com.cookbook.book.service;

import com.cookbook.book.model.Folder;
import com.cookbook.book.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderServiceImpl implements FolderService {

    @Autowired
    private FolderRepository folderRepository;

    @Override
    public Folder createFolder(Folder folder) {
        return folderRepository.save(folder);
    }

    @Override
    public List<Folder> getFoldersByAccountId(int accountId) {
        return folderRepository.findByAccountId(accountId);
    }

    @Override
    public Folder getFolderById(int id) {
        return folderRepository.findById(id).orElse(null);
    }

    @Override
    public void updateFolder(int id, Folder folder) {
        if (folderRepository.existsById(id)) {
            folder.setId(id);
            folderRepository.save(folder);
        }
    }

    @Override
    public void deleteFolder(int id) {
        folderRepository.deleteById(id);
    }
}

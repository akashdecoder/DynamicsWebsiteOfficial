package com.dynamics.website.service;

import com.dynamics.website.exceptions.FileStorageException;
import com.dynamics.website.exceptions.MyFileNotFoundException;
import com.dynamics.website.model.FileUser;
import com.dynamics.website.repository.FileUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    @Autowired
    private FileUserRepository fileUserRepository;

    public FileUser storeFile(MultipartFile multipartFile) {
        String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        try {
            if(filename.contains("..")) {
                throw new FileStorageException("Invalid Path" + filename);
            }
            FileUser fileUser = new FileUser(filename, multipartFile.getContentType(), multipartFile.getBytes());
            return fileUserRepository.save(fileUser);
        } catch (IOException e) {
            throw new FileStorageException("Could not store file " + filename + ". Please try again!", e);
        }
    }

    public FileUser getFile(String fileId) {
        return fileUserRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
}

package com.dynamics.website.service;

import com.dynamics.website.model.FileUser;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.UUID;

@Service
public class FileService {
    private static String TEMP_URL = "";
    private static final String DOWNLOAD_URL = "";


    public String uploadFile(File file, String fileName) throws IOException {
        BlobId blobId = BlobId.of("dynamicspoc-95ae9.appspot.com", fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                .setContentType("media")
                .build();

        Credentials credentials = GoogleCredentials.fromStream(new FileInputStream(
                "src/main/resources/dynamicspoc-95ae9-firebase-adminsdk-v2gz6-3dec038427.json"
        ));
        Storage storage = StorageOptions.newBuilder()
                .setCredentials(credentials).build().getService();
        storage.create(blobInfo, Files.readAllBytes(file.toPath()));
        System.out.println(file.toPath());
        return String.format(DOWNLOAD_URL, URLEncoder.encode(fileName, StandardCharsets.UTF_8));
    }

    private File convertToFile(MultipartFile multipartFile, String fileName) throws IOException {
        File tempFile = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(multipartFile.getBytes());
            fos.close();
        }
        return tempFile;
    }

    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public String upload(MultipartFile multipartFile) throws IOException{
        FileUser fileUser = new FileUser();
        try {
            System.out.println(multipartFile);
            String fileName = multipartFile.getOriginalFilename();
            fileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));  // to generated random string values for file name

            File file = this.convertToFile(multipartFile, fileName);
            TEMP_URL = this.uploadFile(file, fileName);
            file.delete();
            return "Hello";
        } catch (Exception e) {
            e.printStackTrace();
            return "Hello";
        }
    }
}

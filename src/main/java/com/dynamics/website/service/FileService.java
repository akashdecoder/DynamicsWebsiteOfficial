package com.dynamics.website.service;

import com.dynamics.website.model.FileUser;
import com.dynamics.website.model.User;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;

@Service
public class FileService
{

    private static String TEMP_URL = "";
    private static final String DOWNLOAD_URL = "https://storage.googleapis.com/dynamicspoc-95ae9.appspot.com/%s";

    public String uploadFile(File file, String fileName) throws IOException {
        BlobId blobId = BlobId.of("dynamicspoc-95ae9.appspot.com", fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                .setContentType("application/pdf")
                .build();

        Credentials credentials = GoogleCredentials.fromStream(new FileInputStream("src/main/resources/dynamicspoc-95ae9-firebase-adminsdk-v2gz6-4b8fc1eec3.json"));
        Storage storage = StorageOptions.newBuilder()
                .setCredentials(credentials).build().getService();
        storage.create(blobInfo, Files.readAllBytes(file.toPath()));
        return String.format(DOWNLOAD_URL, URLEncoder.encode(fileName,  "UTF-8"));
    }

    private File convertToFile(MultipartFile multipartFile, String fileName) throws IOException {
        File tempFile = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(multipartFile.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempFile;
    }

    private String getExtension(String fileName) {
    return fileName.substring(fileName.lastIndexOf("."));
}

    public String upload(MultipartFile multipartFile, User user) throws IOException{
        try {
            String fileName = multipartFile.getOriginalFilename();
            fileName = user.getUsn().concat(this.getExtension(fileName));

            File file = this.convertToFile(multipartFile, fileName);
            TEMP_URL = this.uploadFile(file, fileName);
            file.delete();
            return TEMP_URL;
        } catch (Exception e) {
            e.printStackTrace();
            return "Hello";
        }
    }
}

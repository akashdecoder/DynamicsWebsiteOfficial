package com.dynamics.website.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@AllArgsConstructor
@NoArgsConstructor
public class FileUser {

    private @Getter @Setter
    MultipartFile multipartFile;

    private @Getter @Setter
    File file;
}

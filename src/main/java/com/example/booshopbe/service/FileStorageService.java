package com.example.booshopbe.service;


import com.example.booshopbe.config.FileStorageProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileStorageService {
    private final Path fileLogoStorageLocation;

    public FileStorageService(FileStorageProperties fileStorageProperties){
        this.fileLogoStorageLocation = Paths.get(fileStorageProperties.getUploadLogoDir()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(fileLogoStorageLocation);
        }catch (Exception ex){
            throw new RuntimeException("Counld not create the directory where the uploaded file will be strored", ex);
        }
    }

    public String storeLogoFile(MultipartFile file){
        return storeFile(fileLogoStorageLocation, file);
    }

    private String storeFile(Path location, MultipartFile file){
        UUID uuid = UUID.randomUUID();
        String ext = StringUtils.getFilenameExtension(file.getOriginalFilename());
        String filename = uuid.toString()+"."+ext;
        try {
            if (filename.contains("..")){
                throw new RuntimeException("Sorry! Filename contains invalid path sequence: " +filename);
            }
            Path targetLocation = location.resolve(filename);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return filename;
        }catch (Exception ex){
            throw  new RuntimeException("Could not store File " +filename+". Please try again", ex);
        }
    }

    public Resource loadLogoFileAsResource(String filename){
        return loadFileAsResource(fileLogoStorageLocation, filename);
    }

    private Resource loadFileAsResource(Path location, String filename){
        try{
            Path filePath = location.resolve(filename).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()){
                return resource;
            }else {
                throw new RuntimeException("File Not Found");
            }
        }catch (Exception ex){
            throw new RuntimeException("File Not Found",ex);
        }
    }

    private void deleteFile(Path location, String filename){
        try {
            Path filePath = location.resolve(filename).normalize();
            if (!Files.exists(filePath)){
                throw new RuntimeException("File not found");
            }
            Files.delete(filePath);
        }catch (Exception ex){
            throw new RuntimeException("File not found" , ex);
        }
    }

}

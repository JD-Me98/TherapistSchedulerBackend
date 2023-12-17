package com.therapy.therapySessionScheduler.controller;

import com.therapy.therapySessionScheduler.playLoad.FileResponse;
import com.therapy.therapySessionScheduler.service.ImageServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/file")
public class ImageController {

    private static final String IMAGE_FOLDER_PATH = "image/";
    @Autowired
    private ImageServiceImpl imageService;

    @Value("${project.image}")
    private String path;

    @PostMapping("/upload")
    public ResponseEntity<FileResponse> uploadImage(@RequestParam("image") MultipartFile image) {
        String fileName = null;
        try {
            fileName = imageService.uploadImage(path, image);
        } catch (IOException e) {
           e.printStackTrace();
            return new ResponseEntity<>(new FileResponse(null, "Image failed to Upload due to error on server!"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new FileResponse(fileName, "Image is Successfully Uploaded!"), HttpStatus.OK);
    }



}
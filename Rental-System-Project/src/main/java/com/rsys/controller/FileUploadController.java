package com.rsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rsys.services.interfaces.ICloudinaryService;



@RestController
public class FileUploadController {

    @Autowired
    private ICloudinaryService cloudinaryService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
    	try {
        String url = cloudinaryService.uploadFile(file);
        return "File uploaded successfully: File path :  " + url;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		return null;
    }
}
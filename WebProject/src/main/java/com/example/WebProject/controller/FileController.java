package com.example.WebProject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
    
    @PostMapping("/save")
    public @ResponseBody String save(@RequestParam List<MultipartFile> files) {
        // Save the files
        // for (MultipartFile file : files) {
        // }
        
        // Return an empty string to signify success
        return "";
    }
    
    @PostMapping("/remove")
    public @ResponseBody String remove(@RequestParam String[] fileNames) {
        // Remove the files
        // for (String fileName : fileNames) {
        // }
        // Return an empty string to signify success
        return "";
    }
}
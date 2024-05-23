package com.example.spring_demo.controller;

import com.example.spring_demo.entity.Headphone;
import com.example.spring_demo.service.HeadphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/headphones")
public class HeadphoneController {
    @Autowired
    HeadphoneService headphoneService;

    @GetMapping("")
    public String getAllHeadphones(Model model) {
        model.addAttribute("headphones", headphoneService.findAll());
        return "headphones/headphones";
    }

    @GetMapping("/{id}")
    public String getHeadphoneById(@PathVariable Long id, Model model) {
        Headphone headphone = headphoneService.findPair(id);
        if(headphone != null){
            model.addAttribute("headphone", headphone);
            return "headphones/single-headphone";
        }else{
            return "error/404";
        }
    }

    private String saveImage(MultipartFile file) {
        try {
            String uploadDir = "src/main/resources/static/images/";
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir + fileName);
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, file.getBytes());
            return "/images/" + fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void removeImage(Long id) {
        Headphone headphone = headphoneService.findPair(id);
        if(headphone != null){
            headphone.setImageUrl(null);
            headphoneService.updatePair(id, headphone);
        }
    }

    @GetMapping("/new")
    public String showAddPairForm(Model model) {
        model.addAttribute("headphone", new Headphone());
        List<String> existingTypes = headphoneService.distinctTypes();
        List<String> existingConnections = headphoneService.distinctConnections();
        model.addAttribute("existingTypes", existingTypes);
        model.addAttribute("existingConnections", existingConnections);
        return "headphones/headphone-form";
    }

    @PostMapping("/add")
    public String addPair(@ModelAttribute Headphone headphone, @RequestParam("image") MultipartFile file) {
        if(!file.isEmpty()){
            String uploadDir = saveImage(file);
            headphone.setImageUrl(uploadDir);
        }
        Headphone savedHeadphone = headphoneService.addPair(headphone);
        return "redirect:/headphones";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Headphone headphone = headphoneService.findPair(id);
        model.addAttribute("headphone", headphone);
        model.addAttribute("existingTypes", headphoneService.distinctTypes());
        model.addAttribute("existingConnections", headphoneService.distinctConnections());
        return "headphones/headphone-form";
    }

    @PostMapping("/update/{id}")
    public String updateHeadphone(@PathVariable Long id, @ModelAttribute Headphone headphone, @RequestParam("image") MultipartFile file) {
        if(!file.isEmpty()){
            String uploadDir = saveImage(file);
            headphone.setImageUrl(uploadDir);
        }
        headphoneService.updatePair(id, headphone);
        return "redirect:/headphones";
    }

    @GetMapping("/removeImage/{id}")
    public String deleteImage(@PathVariable Long id) {
        removeImage(id);
        return "redirect:/headphones/edit/" + id;
    }

    @PostMapping("/delete/{id}")
    public String deletePair(@PathVariable Long id) {
        headphoneService.deletePair(id);
        return "redirect:/headphones";
    }
}

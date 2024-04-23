package com.example.spring_demo.controller;

import com.example.spring_demo.entity.Headphone;
import com.example.spring_demo.repository.HeadphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/headphones")
public class HeadphoneController {
    @Autowired
    private HeadphoneRepository headphoneRepository;

    @GetMapping("/all")
    public List<Headphone> getAllHeadphones() {
        return headphoneRepository.findAll();
    }
}

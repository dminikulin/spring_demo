package com.example.spring_demo.controller;

import com.example.spring_demo.entity.Headphone;
import com.example.spring_demo.service.HeadphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HeadphoneController {
    @Autowired
    HeadphoneService headphoneService;

    @GetMapping("/headphones")
    public String getAllHeadphones(Model model) {
        model.addAttribute("headphones", headphoneService.findAll());
        return "headphones/headphones";
    }

    @GetMapping("/headphones/{id}")
    public Headphone getHeadphoneById(@PathVariable Long id) {
        return headphoneService.findPair(id);
    }

    @PostMapping("/headphones/add")
    public Headphone addPair(@RequestBody Headphone headphone) {
        return headphoneService.addPair(headphone);
    }

    @PatchMapping("/headphones/{id}")
    public Headphone updatePair(@PathVariable Long id, @RequestBody Headphone headphone) {
        return headphoneService.updatePair(id, headphone);
    }

    @DeleteMapping("/headphones/{id}")
    public void deletePair(@PathVariable Long id) {
        headphoneService.deletePair(id);
    }
}

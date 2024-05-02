package com.example.spring_demo.controller;

import com.example.spring_demo.entity.Headphone;
import com.example.spring_demo.service.HeadphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/headphones")
public class HeadphoneController {
    @Autowired
    HeadphoneService headphoneService;

    @GetMapping("/")
    public List<Headphone> getAllHeadphones() {
        return headphoneService.findAll();
    }

    @GetMapping("/{id}")
    public Headphone getHeadphoneById(@PathVariable Long id) {
        return headphoneService.findPair(id);
    }

    @PostMapping("/add")
    public Headphone addPair(@RequestBody Headphone headphone) {
        return headphoneService.addPair(headphone);
    }

    @PatchMapping("/{id}")
    public Headphone updatePair(@PathVariable Long id, @RequestBody Headphone headphone) {
        return headphoneService.updatePair(id, headphone);
    }

    @DeleteMapping("/{id}")
    public void deletePair(@PathVariable Long id) {
        headphoneService.deletePair(id);
    }
}

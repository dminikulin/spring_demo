package com.example.spring_demo.controller;

import com.example.spring_demo.entity.Headphone;
import com.example.spring_demo.service.HeadphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class HeadphoneController {
    @Autowired
    HeadphoneService headphoneService;

    @GetMapping("/headphones")
    public List<Headphone> getAllHeadphones() {
        return headphoneService.findAll();
    }

    @GetMapping("/headphones/{id}")
    public Headphone getHeadphoneById(@PathVariable Long id) {
        return headphoneService.findById(id);
    }

    @GetMapping("/headphones/search")
    public List<Headphone> searchHeadphone(
            @RequestParam(required = false) String brandName,
            @RequestParam(required = false) String typeName,
            @RequestParam(required = false) String connectionName
    ) {
        return headphoneService.multiSearch(brandName, typeName, connectionName);
    }

//    @GetMapping("/headphones/search")
//    public List<Headphone> getHeadphonesByBrandName(@RequestParam String brandName) {
//        return headphoneService.findByBrandName(brandName);
//    }
//
//    @GetMapping("/headphones/search")
//    public List<Headphone> getHeadphonesByConnectionName(@RequestParam String connectionName) {
//        return headphoneService.findByConnectionName(connectionName);
//    }
}

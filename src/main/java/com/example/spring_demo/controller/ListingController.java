package com.example.spring_demo.controller;

import com.example.spring_demo.entity.Listing;
import com.example.spring_demo.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listings")
public class ListingController {
    @Autowired
    ListingService listingService;

    @GetMapping("/")
    public List<Listing> getAllListings(){
        return listingService.findAll();
    }

    @GetMapping("/{id}")
    public Listing getListingById(@PathVariable Long id){
        return listingService.findListing(id);
    }

    @PostMapping("/add")
    public Listing addListing(@RequestBody Listing listing){
        return listingService.addListing(listing);
    }

    @PatchMapping("/{id}")
    public Listing updateListing(@PathVariable Long id, @RequestBody Listing listing){
        return listingService.updateListing(id, listing);
    }

    @DeleteMapping("/{id}")
    public void deleteListing(@PathVariable Long id){
        listingService.removeListing(id);
    }
}

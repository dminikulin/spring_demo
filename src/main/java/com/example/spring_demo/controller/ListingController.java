package com.example.spring_demo.controller;

import com.example.spring_demo.entity.Listing;
import com.example.spring_demo.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ListingController {
    @Autowired
    ListingService listingService;

    @GetMapping("/listings")
    public String getAllListings(Model model){
        model.addAttribute("listings", listingService.findAll());
        return "listings/listings";
    }

    @GetMapping("/listings/{id}")
    public Listing getListingById(@PathVariable Long id){
        return listingService.findListing(id);
    }

    @PostMapping("/listings/add")
    public Listing addListing(@RequestBody Listing listing){
        return listingService.addListing(listing);
    }

    @PatchMapping("/listings/{id}")
    public Listing updateListing(@PathVariable Long id, @RequestBody Listing listing){
        return listingService.updateListing(id, listing);
    }

    @DeleteMapping("/listings/{id}")
    public void deleteListing(@PathVariable Long id){
        listingService.removeListing(id);
    }
}

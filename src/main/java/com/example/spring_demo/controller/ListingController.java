package com.example.spring_demo.controller;

import com.example.spring_demo.entity.Headphone;
import com.example.spring_demo.entity.Listing;
import com.example.spring_demo.service.HeadphoneService;
import com.example.spring_demo.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/listings")
public class ListingController {
    @Autowired
    ListingService listingService;
    @Autowired
    HeadphoneService headphoneService;

    @GetMapping("")
    public String getAllListings(Model model){
        model.addAttribute("listings", listingService.findAll());
        return "listings/listings";
    }

    @GetMapping("/{id}")
    public String getListingById(@PathVariable Long id, Model model){
        Listing listing = listingService.findListing(id);
        if(listing != null){
            model.addAttribute("listing", listing);
            return "listings/single-listing";
        }else{
            return "error/404";
        }
    }

    @GetMapping("/new")
    public String addListing(Model model){
        List<Headphone> headphones = headphoneService.findAllNotOnSale();
        model.addAttribute("headphones", headphones);
        model.addAttribute("listing", new Listing());
        return "listings/listing-form";
    }

    @PostMapping("/add")
    public String addListing(Listing listing){
        Listing newListing = listingService.addListing(listing);
        return "redirect:/listings";
    }

    @GetMapping("/edit/{id}")
    public String editListing(@PathVariable Long id, Model model){
        List<Headphone> headphones = headphoneService.findAllNotOnSale();
        Listing listing = listingService.findListing(id);
        model.addAttribute("listing", listing);
        model.addAttribute("headphones", headphones);
        return "listings/listing-form";
    }

    @PostMapping("/update/{id}")
    public String updateListing(@PathVariable Long id, @ModelAttribute Listing listing){
        listingService.updateListing(id, listing);
        return "redirect:/listings";
    }

    @PostMapping("/delete/{id}")
    public String deleteListing(@PathVariable Long id){
        listingService.removeListing(id);
        return "redirect:/listings";
    }

    @PostMapping("/sell/{id}")
    public String sellListing(@PathVariable Long id){
        listingService.sellListing(id);
        return "redirect:/listings";
    }
}

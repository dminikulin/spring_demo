package com.example.spring_demo.service;

import com.example.spring_demo.entity.Headphone;
import com.example.spring_demo.entity.Listing;
import com.example.spring_demo.repository.HeadphoneRepository;
import com.example.spring_demo.repository.ListingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListingService {
    @Autowired
    private ListingRepository listingRepository;

    @Autowired
    private HeadphoneRepository headphoneRepository;

    public List<Listing> findAll(){
        return listingRepository.findAll();
    }

    public Listing findListing(Long id){
        Optional<Listing> listing = listingRepository.findById(id);
        return listing.orElse(null);
    }

    public Listing addListing(Listing listing){
        return listingRepository.save(listing);
    }

    public Listing updateListing(Long id, Listing listingToUpdate){
        if(listingRepository.existsById(id)){
            listingToUpdate.setId(id);
            return listingRepository.save(listingToUpdate);
        }
        return null;
    }

    public void removeListing(Long id){
       listingRepository.deleteById(id);
    }

    @Transactional
    public void sellListing(Long id){
        Listing listing = findListing(id);
        Headphone headphone = listing.getHeadphone();
        listingRepository.delete(listing);
        headphoneRepository.delete(headphone);
    }
}

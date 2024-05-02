package com.example.spring_demo.service;

import com.example.spring_demo.entity.Headphone;
import com.example.spring_demo.repository.HeadphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeadphoneService {
    @Autowired
    private HeadphoneRepository headphoneRepository;

    public List<Headphone> findAll(){
        return headphoneRepository.findAll();
    }

    public Headphone findPair(Long id){
        Optional<Headphone> headphone = headphoneRepository.findById(id);
        return headphone.orElse(null);
    }

    public Headphone addPair(Headphone headphone){
        return headphoneRepository.save(headphone);
    }

    public Headphone updatePair(Long id, Headphone pairToUpdate){
        if(headphoneRepository.existsById(id)){
            pairToUpdate.setId(id);
            return headphoneRepository.save(pairToUpdate);
        }
        return null;
    }

    public void deletePair(Long id){
        headphoneRepository.deleteById(id);
    }
}

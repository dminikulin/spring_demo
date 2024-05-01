package com.example.spring_demo.service;

import com.example.spring_demo.entity.Headphone;
import com.example.spring_demo.repository.HeadphoneRepository;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HeadphoneService {
    @Autowired
    HeadphoneRepository headphoneRepository;

    public List<Headphone> findAll(){
        return headphoneRepository.findAll();
    }

    public Headphone findById(Long id){
        Optional<Headphone> headphone = headphoneRepository.findById(id);
        return headphone.orElse(null);
    }

//    public List<Headphone> findByBrandName(String brandName){
//        List<Headphone> headphones = headphoneRepository.findHeadphonesByBrandName(brandName);
//        return headphones.isEmpty() ? null : headphones;
//    }
//
//    public List<Headphone> findByConnectionName(String connectionName){
//        List<Headphone> headphones = headphoneRepository.findHeadphonesByConnectionName(connectionName);
//        return headphones.isEmpty() ? null : headphones;
//    }

    public List<Headphone> multiSearch(String brandName, String typeName, String connectionName){
        return headphoneRepository.findAll(((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(brandName != null && !brandName.isEmpty()){
                Join<Headphone, Headphone> brandJoin = root.join("brand");
                predicates.add(criteriaBuilder.equal(brandJoin.get("name"), brandName));
            }

            if (typeName != null && !typeName.isEmpty()){
                Join<Headphone, Headphone> typeJoin = root.join("type");
                predicates.add(criteriaBuilder.equal(typeJoin.get("type"), typeName));
            }

            if (connectionName != null && !connectionName.isEmpty()){
                Join<Headphone, Headphone> connectionJoin = root.join("connection");
                predicates.add(criteriaBuilder.equal(connectionJoin.get("connection"), connectionName));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }));
    }
}

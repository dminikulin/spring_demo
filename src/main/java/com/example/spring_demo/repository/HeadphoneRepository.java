package com.example.spring_demo.repository;

import com.example.spring_demo.entity.Headphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadphoneRepository extends JpaRepository<Headphone, Long> {
}

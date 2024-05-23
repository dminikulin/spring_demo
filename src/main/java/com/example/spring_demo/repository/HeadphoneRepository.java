package com.example.spring_demo.repository;

import com.example.spring_demo.entity.Headphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeadphoneRepository extends JpaRepository<Headphone, Long>{
    @Query("SELECT DISTINCT type FROM Headphone")
    List<String> findDistinctTypes();
    @Query("SELECT DISTINCT connection FROM Headphone")
    List<String> findDistinctConnections();
}

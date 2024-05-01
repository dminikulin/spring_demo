package com.example.spring_demo.repository;

import com.example.spring_demo.entity.Headphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeadphoneRepository extends JpaRepository<Headphone, Long>, JpaSpecificationExecutor<Headphone> {
//    @Query(value = "SELECT H.* FROM headphones H LEFT JOIN brands B on H.brand = B.id WHERE B.name = ?1", nativeQuery = true)
//    List<Headphone> findHeadphonesByBrandName(String brandName);
//    @Query(value = "SELECT H.* FROM headphones H LEFT JOIN connections C on H.connection = C.id WHERE C.connection = ?1", nativeQuery = true)
//    List<Headphone> findHeadphonesByConnectionName(String connectionName);
//    List<Headphone> findHeadphonesByTypeName(String type);
    @Query(value = "SELECT H FROM Headphone H " +
            "INNER JOIN H.brand B " +
            "INNER JOIN H.type T " +
            "INNER JOIN H.connection C " +
            "WHERE (B.name = :brandName OR :brandName IS NULL) " +
            "AND (T.type = :typeName OR :typeName IS NULL)" +
            "AND (C.connection = :connectionName OR :connectionName IS NULL)")
    List<Headphone> multiSearch(@Param("brandName") String brandName, @Param("typeName") String typeName, @Param("connectionName") String connectionName);
}

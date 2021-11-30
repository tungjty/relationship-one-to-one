package com.example.demo.repository;

import com.example.demo.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {

    @Modifying
    // Native Query
    @Query(
            value = "update tbl_office set address_id = null where address_id = ?1",
            nativeQuery = true
    )
    void removeAddressAndNotDeleteOffice(Long id);

    List<Office> findByOfficeNameContaining(String s);
}
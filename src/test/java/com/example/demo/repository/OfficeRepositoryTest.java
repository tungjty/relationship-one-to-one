package com.example.demo.repository;

import com.example.demo.model.Address;
import com.example.demo.model.Office;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OfficeRepositoryTest {

    private final OfficeRepository officeRepository;

    @Autowired
    OfficeRepositoryTest(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @Test
    public void saveOfficeTest() {
        Address toyotaAddress = Address.builder()
                .address("0123 Tran Hung Dao Street Ward 1, HCM")
                .build();
        Office toyota = Office.builder()
                .officeName("Toyota Ben Thanh")
                .taxCode("VN-456000")
                .address(toyotaAddress)
                .build();

        officeRepository.save(toyota);
    }

    @Test
    public void findByOfficeNameContainingTest() {
        List<Office> list = officeRepository.findByOfficeNameContaining("vinfast");
        System.out.println(list);
    }

}
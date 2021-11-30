package com.example.demo.repository;

import com.example.demo.model.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AddressRepositoryTest {

    private final AddressRepository addressRepository;

    @Autowired
    AddressRepositoryTest(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Test
    public void printAllAddresses() {
        List<Address> list = addressRepository.findAll();
        System.out.println(list);
    }

}
package com.example.demo.service;

import com.example.demo.model.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAddresses();

    void deleteAddressById(Long id);

    void deleteAddressAndNotDeleteOffice(Long id);
}

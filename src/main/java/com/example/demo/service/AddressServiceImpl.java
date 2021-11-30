package com.example.demo.service;

import com.example.demo.model.Address;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.OfficeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService{

    private final AddressRepository addressRepository;
    private final OfficeRepository officeRepository;

    @Override
    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public void deleteAddressById(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAddressAndNotDeleteOffice(Long id) {
        officeRepository.removeAddressAndNotDeleteOffice(id);
        addressRepository.deleteOfficeOnly(id);
    }
}

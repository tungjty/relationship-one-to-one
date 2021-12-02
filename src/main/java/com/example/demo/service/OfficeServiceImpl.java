package com.example.demo.service;

import com.example.demo.model.Address;
import com.example.demo.model.Office;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.OfficeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OfficeServiceImpl implements OfficeService{

    private final OfficeRepository officeRepository;
    private final AddressRepository addressRepository;

    @Override
    public List<Office> getOffices() {
        return officeRepository.findAll();
    }

    @Override
    public void deleteOfficeById(Long id) {
        officeRepository.deleteById(id);
    }

    @Override
    public void removeOrphanAddressFromOffice(Long ofOfficeId) {
        Optional<Office> ofOfficeOptional = officeRepository.findById(ofOfficeId);
        Office office = ofOfficeOptional.get();
        office.setAddress(null);

        // TODO : REMOVE ADDRESS -> REMOVE OFFICE DUE TO 'CascadeType.REMOVE' IN ADDRESS ENTITY
        // TODO : THIS IS JUST FOR DEMO PURPOSE
        officeRepository.save(office);
    }

}

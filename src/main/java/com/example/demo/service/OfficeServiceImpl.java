package com.example.demo.service;

import com.example.demo.model.Office;
import com.example.demo.repository.OfficeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OfficeServiceImpl implements OfficeService{

    private final OfficeRepository officeRepository;

    @Override
    public List<Office> getOffices() {
        return officeRepository.findAll();
    }

    @Override
    public void deleteOfficeById(Long id) {
        officeRepository.deleteById(id);
    }

}

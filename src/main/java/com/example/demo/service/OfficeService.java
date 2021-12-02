package com.example.demo.service;

import com.example.demo.model.Office;

import java.util.List;

public interface OfficeService {

    List<Office> getOffices();

    void deleteOfficeById(Long id);

    void removeOrphanAddressFromOffice(Long ofOfficeId);
}

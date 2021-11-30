package com.example.demo.controller;

import com.example.demo.model.Address;
import com.example.demo.model.Office;
import com.example.demo.service.AddressService;
import com.example.demo.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class HomeController {

    private final OfficeService officeService;
    private final AddressService addressService;

    @Autowired
    public HomeController(OfficeService officeService, AddressService addressService) {
        this.officeService = officeService;
        this.addressService = addressService;
    }

    // OFFICE
    @GetMapping(path = "office/all")
    public List<Office> getAllOffices() {
        return officeService.getOffices();
    }

    @DeleteMapping(path = "office/delete/{id}")
    public String deleteOfficeById(@PathVariable("id") Long id) {
        officeService.deleteOfficeById(id);
        return "OFFICE WAS REMOVED SUCCESSFULLY";
    }

    // ADDRESS
    @GetMapping(path = "address/all")
    public List<Address> getAllAddresses() {
        return addressService.getAddresses();
    }

    @DeleteMapping(path = "address/delete/{id}")
    public String deleteAddressById(@PathVariable("id") Long id) {
        addressService.deleteAddressById(id);
        return "ADDRESS WAS REMOVED SUCCESSFULLY";
    }

    @DeleteMapping(path = "address/delete/only/{id}")
    public String delAddressAndNotDeleteOffice(@PathVariable("id") Long id) {
        addressService.deleteAddressAndNotDeleteOffice(id);
        return "ADDRESS WAS REMOVED SUCCESSFULLY AND OFFICE WAS SET TO NULL";
    }

}

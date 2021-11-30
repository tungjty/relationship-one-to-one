package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor // for unit test
@Builder // for unit test
@Table(name = "tbl_address")
public class Address {

    @Id
    @Column(name = "address_id", nullable = false)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_sequence"
    )
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_id_seq",
            allocationSize = 1
    )
    private Long addressId;

    private String address;

    @OneToOne(
            mappedBy = "address",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
            //fetch = FetchType.EAGER     //default 'EAGER'
    )
    // NOTE : WE WON'T USE @JoinColumn HERE
    private Office office;

    public Address(String address) {
        this.address = address;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long id) {
        this.addressId = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // WE CAN NOT ENABLE THIS DUE TO LOOP ERROR
    // IF WE WANT TO ENABLE THIS METHOD TO GET OFFICE OBJECT ->
    // WE NEED TO DISABLE getAddress() IN OFFICE ENTITY
//    public Office getOffice() {
//        return office;
//    }

    public void setOffice(Office office) {
        this.office = office;
    }
}

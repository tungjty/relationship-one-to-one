package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor // for unit test
@Builder // for unit test
@ToString(exclude = "address")
@Table(
        name = "tbl_office",
        uniqueConstraints = @UniqueConstraint(
                name = "unique_tax_code",
                columnNames = "tax_code"
        )
)
public class Office {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "office_sequence" // name of generated table
    )
    @SequenceGenerator(
            name = "office_sequence",
            sequenceName = "office_id_seq", // override name of generated table
            initialValue = 10,
            allocationSize = 1
    )
    private Long officeId;

    private String officeName;

    @Column(
            name = "tax_code",
            nullable = false
    )
    private String taxCode;

    @OneToOne(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true,
            fetch = FetchType.EAGER, // default 'EAGER'
            optional = true // DEFAULT, NOT REQUIRE INSERT ADDRESS WHEN INSERT OFFICE
//            optional = false // REQUIRE INSERT ADDRESS WHEN INSERT OFFICE
    )
    @JoinColumn(
            name = "address_id", // NAME OF REFERENCE COLUMN
            referencedColumnName = "addressId",
            foreignKey = @ForeignKey(name = "address_address_id_fk")
    )
    private Address address;

    public Office(String officeName,
                  String taxCode,
                  Address address) {
        this.officeName = officeName;
        this.taxCode = taxCode;
        this.address = address;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

package com.switchfully.teamteam.parkshark.domain.members.license_plates;

import javax.persistence.*;

@Entity
@Table(name="LICENSE_PLATE")
public class LicensePlate {

    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "sequenceLicencePlate")
    @SequenceGenerator(name = "sequenceLicencePlate", sequenceName = "PARKSHARK_LICENSE_PLATE_SEQ", allocationSize = 1)
    private Long id;
    @Column(name = "LP_NUMBER")
    private String number;
    @Column(name = "COUNTRY")
    private String issuingCountry;

    public LicensePlate() {
    }


    public LicensePlate(String number, String issuingCountry) {
        this.number = number;
        this.issuingCountry = issuingCountry;
    }

    public String getNumber() {
        return number;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }
}

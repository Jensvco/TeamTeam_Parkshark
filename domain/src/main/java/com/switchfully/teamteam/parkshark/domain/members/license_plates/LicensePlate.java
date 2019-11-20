package com.switchfully.teamteam.parkshark.domain.members.license_plates;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LICENSE_PLATE")
public class LicensePlate {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceLicencePlate")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LicensePlate that = (LicensePlate) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(number, that.number) &&
                Objects.equals(issuingCountry, that.issuingCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, issuingCountry);
    }
}

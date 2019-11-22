package com.switchfully.teamteam.parkshark.domain;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceAddress")
    @SequenceGenerator(name = "sequenceAddress", sequenceName = "PARKSHARK_ADDRESS_SEQ", allocationSize = 1)
    private int id;

    @Column(name = "STREET_NAME")
    private String streetName;

    @Column(name = "HOUSE_NUMBER")
    private String houseNumber;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "CITY")
    private String city;

    /* Required by JPA */
    private Address() {
    }

    private Address(Builder builder) {
        streetName = builder.streetName;
        houseNumber = builder.houseNumber;
        postalCode = builder.postalCode;
        city = builder.city;
    }

    public int getId() {
        return id;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public static final class Builder {
        private String streetName;
        private String houseNumber;
        private String postalCode;
        private String city;

        public static Builder address() {
            return new Builder();
        }

        public Builder withStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder withHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
            return this;
        }

        public Builder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}

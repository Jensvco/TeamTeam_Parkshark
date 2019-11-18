package com.switchfully.teamteam.parkshark.domain;

public class Address {
    private int id;
    private String streetName;
    private String houseNumber;
    private String postalCode;
    private String city;

    private Address(Builder builder) {
        streetName = builder.streetName;
        houseNumber = builder.houseNumber;
        postalCode = builder.postalCode;
        city = builder.city;
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

package com.switchfully.teamteam.parkshark.api.addresses.dto;

public class CreateAddressDto {
    private String streetName;
    private String houseNumber;
    private String postalCode;
    private String city;

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

    public CreateAddressDto(String streetName, String houseNumber, String postalCode, String city) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city;


    }
}

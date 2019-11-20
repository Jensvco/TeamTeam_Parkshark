package com.switchfully.teamteam.parkshark.api.addresses.dto;

public class AddressDto {
    private int id;
    private String streetName;
    private String houseNumber;
    private String postalCode;
    private String city;

    public AddressDto() {
    }

    public AddressDto(int id, String streetName, String houseNumber, String postalCode, String city) {
        this.id = id;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city;
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
}

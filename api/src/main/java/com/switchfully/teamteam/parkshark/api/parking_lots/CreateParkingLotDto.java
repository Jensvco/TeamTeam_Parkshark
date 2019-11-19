package com.switchfully.teamteam.parkshark.api.parking_lots;

import com.switchfully.teamteam.parkshark.api.addresses.dto.AddressDto;
import com.switchfully.teamteam.parkshark.api.contact_persons.dto.ContactPersonDto;
import com.switchfully.teamteam.parkshark.api.parking_lots.parking_lot_categories.ParkingLotCategoryDto;

public class CreateParkingLotDto {
    private String name;
    private ParkingLotCategoryDto parkingLotCategoryDto;
    private int capacity;
    private ContactPersonDto contactPersonDto;
    private AddressDto addressDto;
    private double pricePerHour;

    public CreateParkingLotDto(String name, ParkingLotCategoryDto parkingLotCategoryDto, int capacity, ContactPersonDto contactPersonDto, AddressDto addressDto, double pricePerHour) {
        this.name = name;
        this.parkingLotCategoryDto = parkingLotCategoryDto;
        this.capacity = capacity;
        this.contactPersonDto = contactPersonDto;
        this.addressDto = addressDto;
        this.pricePerHour = pricePerHour;
    }

    public String getName() {
        return name;
    }

    public ParkingLotCategoryDto getParkingLotCategoryDto() {
        return parkingLotCategoryDto;
    }

    public int getCapacity() {
        return capacity;
    }

    public ContactPersonDto getContactPersonDto() {
        return contactPersonDto;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }
}

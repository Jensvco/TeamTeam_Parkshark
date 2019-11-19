package com.switchfully.teamteam.parkshark.api.parking_lots;

import com.switchfully.teamteam.parkshark.api.addresses.dto.AddressDto;
import com.switchfully.teamteam.parkshark.api.contact_persons.dto.ContactPersonDto;
import com.switchfully.teamteam.parkshark.api.parking_lots.parking_lot_categories.ParkingLotCategoryDto;

public class CreateParkingLotDto {
    private String name;
    private ParkingLotCategoryDto parkingLotCategory;
    private int capacity;
    private ContactPersonDto contactPerson;
    private AddressDto address;
    private double pricePerHour;

    public CreateParkingLotDto(String name, ParkingLotCategoryDto parkingLotCategory, int capacity, ContactPersonDto contactPersonDto, AddressDto addressDto, double pricePerHour) {
        this.name = name;
        this.parkingLotCategory = parkingLotCategory;
        this.capacity = capacity;
        this.contactPerson = contactPersonDto;
        this.address = addressDto;
        this.pricePerHour = pricePerHour;
    }

    public String getName() {
        return name;
    }

    public ParkingLotCategoryDto getParkingLotCategory() {
        return parkingLotCategory;
    }

    public int getCapacity() {
        return capacity;
    }

    public ContactPersonDto getContactPerson() {
        return contactPerson;
    }

    public AddressDto getAddress() {
        return address;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }
}

package com.switchfully.teamteam.parkshark.api.parking_lots;

import com.switchfully.teamteam.parkshark.api.addresses.dto.AddressDto;
import com.switchfully.teamteam.parkshark.api.contact_persons.dto.ContactPersonDto;
import com.switchfully.teamteam.parkshark.domain.ParkingLotCategory;

public class ParkingLotDto {

    private long id;
    private String name;
    private ParkingLotCategory parkingLotCategoryDto;
    private int capacity;
    private ContactPersonDto contactPersonDto;
    private AddressDto addressDto;
    private double pricePerHour;

    public ParkingLotDto(long id, String name, ParkingLotCategory parkingLotCategoryDto, int capacity, ContactPersonDto contactPersonDto, AddressDto addressDto, double pricePerHour) {
        this.id = id;
        this.name = name;
        this.parkingLotCategoryDto = parkingLotCategoryDto;
        this.capacity = capacity;
        this.contactPersonDto = contactPersonDto;
        this.addressDto = addressDto;
        this.pricePerHour = pricePerHour;
    }
}

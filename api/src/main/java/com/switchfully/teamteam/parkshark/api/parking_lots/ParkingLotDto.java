package com.switchfully.teamteam.parkshark.api.parking_lots;

import com.switchfully.teamteam.parkshark.api.addresses.dto.AddressDto;
import com.switchfully.teamteam.parkshark.api.contact_persons.dto.ContactPersonDto;
import com.switchfully.teamteam.parkshark.api.parking_lots.parking_lot_categories.ParkingLotCategoryDto;
import com.switchfully.teamteam.parkshark.domain.models.ParkingLot;

public class ParkingLotDto {

    private long id;
    private String name;
    private ParkingLotCategoryDto parkingLotCategory;
    private int capacity;
    private ContactPersonDto contactPerson;
    private AddressDto address;
    private double pricePerHour;

    public ParkingLotDto() {
    }

    public ParkingLotDto(long id, String name, ParkingLotCategoryDto parkingLotCategory, int capacity, ContactPersonDto contactPerson, AddressDto address, double pricePerHour) {
        this.id = id;
        this.name = name;
        this.parkingLotCategory = parkingLotCategory;
        this.capacity = capacity;
        this.contactPerson = contactPerson;
        this.address = address;
        this.pricePerHour = pricePerHour;
    }
}

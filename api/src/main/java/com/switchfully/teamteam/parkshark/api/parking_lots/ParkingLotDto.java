package com.switchfully.teamteam.parkshark.api.parking_lots;

import com.switchfully.teamteam.parkshark.api.addresses.dto.AddressDto;
import com.switchfully.teamteam.parkshark.api.contact_persons.dto.ContactPersonDto;
import com.switchfully.teamteam.parkshark.api.divisions.dtos.DivisionDto;
import com.switchfully.teamteam.parkshark.domain.ParkingLotCategory;

public class ParkingLotDto {

    private int id;
    private String name;
    private ParkingLotCategory parkingLotCategory;
    private int capacity;
    private ContactPersonDto contactPerson;
    private AddressDto address;
    private DivisionDto divisionDto;
    private double pricePerHour;

    public ParkingLotDto() {
    }

    public ParkingLotDto(int id, String name, ParkingLotCategory parkingLotCategory, DivisionDto divisionDto, int capacity, ContactPersonDto contactPerson, AddressDto address, double pricePerHour) {
        this.id = id;
        this.name = name;
        this.parkingLotCategory = parkingLotCategory;
        this.divisionDto = divisionDto;
        this.capacity = capacity;
        this.contactPerson = contactPerson;
        this.address = address;
        this.pricePerHour = pricePerHour;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ParkingLotCategory getParkingLotCategory() {
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

    public DivisionDto getDivisionDto() {
        return divisionDto;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }
}

package com.switchfully.teamteam.parkshark.api.parking_lots;

import com.switchfully.teamteam.parkshark.api.addresses.dto.AddressDto;
import com.switchfully.teamteam.parkshark.api.contact_persons.dto.ContactPersonDto;
import com.switchfully.teamteam.parkshark.api.divisions.dtos.DivisionDto;
import com.switchfully.teamteam.parkshark.domain.ParkingLotCategory;

public class ParkingLotDto {

    private long id;
    private String name;
    private ParkingLotCategory parkingLotCategoryDto;
    private int capacity;
    private ContactPersonDto contactPersonDto;
    private AddressDto addressDto;
    private DivisionDto divisionDto;
    private double pricePerHour;

    public ParkingLotDto(long id, String name, ParkingLotCategory parkingLotCategoryDto,DivisionDto divisionDto, int capacity, ContactPersonDto contactPersonDto, AddressDto addressDto, double pricePerHour) {
        this.id = id;
        this.name = name;
        this.parkingLotCategoryDto = parkingLotCategoryDto;
        this.divisionDto=divisionDto;
        this.capacity = capacity;
        this.contactPersonDto = contactPersonDto;
        this.addressDto = addressDto;
        this.pricePerHour = pricePerHour;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ParkingLotCategory getParkingLotCategoryDto() {
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

    public DivisionDto getDivisionDto() {
        return divisionDto;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }
}

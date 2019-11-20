package com.switchfully.teamteam.parkshark.api.parking_lots;

import com.switchfully.teamteam.parkshark.api.addresses.dto.CreateAddressDto;
import com.switchfully.teamteam.parkshark.api.contact_persons.dto.CreateContactPersonDto;
import com.switchfully.teamteam.parkshark.domain.ParkingLotCategory;

public class CreateParkingLotDto {
    private String name;
    private ParkingLotCategory parkingLotCategory;
    private int capacity;
    private CreateContactPersonDto contactPerson;
    private CreateAddressDto address;
    private int division_id;
    private double pricePerHour;

    public CreateParkingLotDto() {
    }

    public CreateParkingLotDto(String name, ParkingLotCategory parkingLotCategory, int division_id, int capacity, CreateContactPersonDto contactPersonDto, CreateAddressDto addressDto, double pricePerHour) {
        this.name = name;
        this.parkingLotCategory = parkingLotCategory;
        this.capacity = capacity;
        this.contactPerson = contactPersonDto;
        this.address = addressDto;
        this.division_id = division_id;
        this.pricePerHour = pricePerHour;
    }

    public int getDivision_id() {
        return division_id;
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

    public CreateContactPersonDto getContactPerson() {
        return contactPerson;
    }

    public CreateAddressDto getAddress() {
        return address;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }


    public static final class Builder {
        private String name;
        private ParkingLotCategory parkingLotCategory;
        private int capacity;
        private CreateContactPersonDto contactPerson;
        private CreateAddressDto address;
        private double pricePerHour;

        public Builder() {
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withParkingLotCategory(ParkingLotCategory parkingLotCategory) {
            this.parkingLotCategory = parkingLotCategory;
            return this;
        }

        public Builder withCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder withContactPerson(CreateContactPersonDto contactPerson) {
            this.contactPerson = contactPerson;
            return this;
        }

        public Builder withAddress(CreateAddressDto address) {
            this.address = address;
            return this;
        }

        public Builder withPricePerHour(double pricePerHour) {
            this.pricePerHour = pricePerHour;
            return this;
        }

        public CreateParkingLotDto build() {
            return new CreateParkingLotDto(this);
        }
    }
}

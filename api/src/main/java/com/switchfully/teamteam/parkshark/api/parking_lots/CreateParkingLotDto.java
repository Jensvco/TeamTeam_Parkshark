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
    private long division_id;
    private double pricePerHour;

    public CreateParkingLotDto() {
    }

    public CreateParkingLotDto(Builder builder) {
        this.name = builder.name;
        this.parkingLotCategory = builder.parkingLotCategory;
        this.capacity = builder.capacity;
        this.contactPerson = builder.contactPerson;
        this.address = builder.address;
        this.division_id = builder.division_id;
        this.pricePerHour = builder.pricePerHour;
    }

    public long getDivision_id() {
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
        private long division_id;

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

        public Builder withDivision_id(long division_id) {
            this.division_id = division_id;
            return this;
        }

        public CreateParkingLotDto build() {
            return new CreateParkingLotDto(this);
        }
    }
}

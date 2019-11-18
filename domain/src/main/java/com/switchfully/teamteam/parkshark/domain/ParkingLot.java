package com.switchfully.teamteam.parkshark.domain;

public class ParkingLot {

    private long id;
    private String name;
    private ParkingLotCategory parkingLotCategory;
    private int capacity;
    private ContactPerson contactPerson;
    private Address address;
    private double pricePerHour;

    private ParkingLot(Builder builder) {
        name = builder.name;
        parkingLotCategory = builder.parkingLotCategory;
        capacity = builder.capacity;
        contactPerson = builder.contactPerson;
        address = builder.address;
        pricePerHour = builder.pricePerHour;
    }

    public long getId() {
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

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public Address getAddress() {
        return address;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public static final class Builder {
        private String name;
        private ParkingLotCategory parkingLotCategory;
        private int capacity;
        private ContactPerson contactPerson;
        private Address address;
        private double pricePerHour;

        public static Builder parkingLot() {
            return new Builder();
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

        public Builder withContactPerson(ContactPerson contactPerson) {
            this.contactPerson = contactPerson;
            return this;
        }

        public Builder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder withPricePerHour(double pricePerHour) {
            this.pricePerHour = pricePerHour;
            return this;
        }

        public ParkingLot build() {
            return new ParkingLot(this);
        }
    }
}

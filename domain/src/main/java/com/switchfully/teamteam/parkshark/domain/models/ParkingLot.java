package com.switchfully.teamteam.parkshark.domain.models;

import com.switchfully.teamteam.parkshark.domain.Address;
import com.switchfully.teamteam.parkshark.domain.ParkingLotCategory;

import javax.persistence.*;

@Entity
@Table(name = "PARKING_LOT")
public class ParkingLot {

    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "sequenceParkingLot")
    @SequenceGenerator(name = "sequenceParkingLot", sequenceName = "PARKSHARK_PARKINGLOT_SEQ", allocationSize = 1)
    private long id;

    @Column(name = "NAME")
    private String name;

    @OneToOne
    @JoinColumn(name = "PARKING_LOT_CATEGORY_ID")
    private ParkingLotCategory parkingLotCategory;

    @Column(name = "CAPACITY")
    private int capacity;

    @OneToOne
    @JoinColumn(name = "CONTACT_PERSON_ID")
    private ContactPerson contactPerson;

    @OneToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @Column(name = "PRICE_PER_HOUR")
    private double pricePerHour;

    private ParkingLot(ParkingLotBuilder parkingLotBuilder) {
        name = parkingLotBuilder.name;
        parkingLotCategory = parkingLotBuilder.parkingLotCategory;
        capacity = parkingLotBuilder.capacity;
        contactPerson = parkingLotBuilder.contactPerson;
        address = parkingLotBuilder.address;
        pricePerHour = parkingLotBuilder.pricePerHour;
    }

    /* Required by JPA */
    private ParkingLot() {
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

    public static final class ParkingLotBuilder {
        private String name;
        private ParkingLotCategory parkingLotCategory;
        private int capacity;
        private ContactPerson contactPerson;
        private Address address;
        private double pricePerHour;

        public static ParkingLotBuilder parkingLot() {
            return new ParkingLotBuilder();
        }

        public ParkingLotBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ParkingLotBuilder withParkingLotCategory(ParkingLotCategory parkingLotCategory) {
            this.parkingLotCategory = parkingLotCategory;
            return this;
        }

        public ParkingLotBuilder withCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public ParkingLotBuilder withContactPerson(ContactPerson contactPerson) {
            this.contactPerson = contactPerson;
            return this;
        }

        public ParkingLotBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public ParkingLotBuilder withPricePerHour(double pricePerHour) {
            this.pricePerHour = pricePerHour;
            return this;
        }

        public ParkingLot build() {
            return new ParkingLot(this);
        }
    }
}

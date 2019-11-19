package com.switchfully.teamteam.parkshark.domain.models;

import com.switchfully.teamteam.parkshark.domain.Address;
import com.switchfully.teamteam.parkshark.domain.ParkingLotCategory;
import com.switchfully.teamteam.parkshark.domain.divisions.Division;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "PARKING_LOT")
public class ParkingLot {

    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "sequenceParkingLot")
    @SequenceGenerator(name = "sequenceParkingLot", sequenceName = "PARKSHARK_PARKINGLOT_SEQ", allocationSize = 1)
    private long id;

    @Column(name = "NAME")
    private String name;

    @OneToOne(cascade = {PERSIST, MERGE, REMOVE, REFRESH, DETACH})
    @JoinColumn(name = "PARKING_LOT_CATEGORY_ID")
    private ParkingLotCategory parkingLotCategory;

    @Column(name = "CAPACITY")
    private int capacity;

    @OneToOne(cascade = {PERSIST, MERGE, REMOVE, REFRESH, DETACH})
    @JoinColumn(name = "CONTACT_PERSON_ID")
    private ContactPerson contactPerson;

    @OneToOne(cascade = {PERSIST, MERGE, REMOVE, REFRESH, DETACH})
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @Column(name = "PRICE_PER_HOUR")
    private double pricePerHour;

    @ManyToOne
    @JoinColumn(name="DIVISION_ID")
    private Division division;

    private ParkingLot(Builder builder) {
        name = builder.name;
        parkingLotCategory = builder.parkingLotCategory;
        capacity = builder.capacity;
        contactPerson = builder.contactPerson;
        address = builder.address;
        pricePerHour = builder.pricePerHour;
        division = builder.division;
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
        public Division division;

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
        public Builder withPricePerHour(Division division){
            this.division = division;
            return this;
        }

        public ParkingLot build() {
            return new ParkingLot(this);
        }
    }
}

package com.switchfully.teamteam.parkshark.domain.models;

import com.switchfully.teamteam.parkshark.domain.Address;
import com.switchfully.teamteam.parkshark.domain.PhoneNumber;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CONTACT_PERSON")
public class ContactPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "NAME")
    private String name;

    @OneToMany
    @JoinColumn(name="CONTACT_PERSON_ID")
    private List<PhoneNumber> phoneNumbers;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne
    @JoinColumn(name="ADDRESS_ID")
    private Address address;

    private ContactPerson(Builder builder) {
        name = builder.name;
        phoneNumbers = builder.phoneNumbers;
        email = builder.email;
        address = builder.address;
    }

    public ContactPerson() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public static final class Builder {
        private String name;
        private List<PhoneNumber> phoneNumbers;
        private String email;
        private Address address;

        public static Builder contactPerson() {
            return new Builder();
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withPhoneNumber(List<PhoneNumber> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public ContactPerson build() {
            return new ContactPerson(this);
        }
    }
}

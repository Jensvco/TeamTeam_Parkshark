package com.switchfully.teamteam.parkshark.domain;

public class ContactPerson {
    private int id;
    private String name;
    private PhoneNumber phoneNumber;
    private String email;
    private Address address;

    private ContactPerson(Builder builder) {
        name = builder.name;
        phoneNumber = builder.phoneNumber;
        email = builder.email;
        address = builder.address;
    }


    public static final class Builder {
        private String name;
        private PhoneNumber phoneNumber;
        private String email;
        private Address address;

        public static Builder contactPerson() {
            return new Builder();
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withPhoneNumber(PhoneNumber phoneNumber) {
            this.phoneNumber = phoneNumber;
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

package com.switchfully.teamteam.parkshark.domain.members;

import com.switchfully.teamteam.parkshark.domain.PhoneNumber;
import com.switchfully.teamteam.parkshark.domain.members.license_plates.LicensePlate;
import oracle.net.jdbc.TNSAddress.Address;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDate;

public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceMember")
    @SequenceGenerator(name = "sequenceMember", sequenceName = "PARKSHARK_MEMBER_SEQ", allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private Address address;
    private PhoneNumber phoneNumber;
    private String email;
    private LicensePlate licensePlate;
    private LocalDate registrationDate;

    public Member(MemberBuilder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        address = builder.address;
        phoneNumber = builder.phoneNumber;
        email = builder.email;
        licensePlate = builder.licensePlate;
        registrationDate = LocalDate.now();
    }

    public static class MemberBuilder {
        private String firstName;
        private String lastName;
        private Address address;
        private PhoneNumber phoneNumber;
        private String email;
        private LicensePlate licensePlate;
        private LocalDate registrationDate;

        public static MemberBuilder member() {
            return new MemberBuilder();
        }

        public MemberBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public MemberBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public MemberBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public MemberBuilder withPhoneNumber(PhoneNumber phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public MemberBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public MemberBuilder withLicensePlate(LicensePlate licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }

        public Member build() {
            return new Member(this);
        }
    }

}

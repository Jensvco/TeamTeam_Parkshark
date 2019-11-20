package com.switchfully.teamteam.parkshark.domain.members;

import com.switchfully.teamteam.parkshark.domain.Address;
import com.switchfully.teamteam.parkshark.domain.PhoneNumber;
import com.switchfully.teamteam.parkshark.domain.members.license_plates.LicensePlate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.PERSIST;

@Entity
@Table(name ="MEMBER")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceMember")
    @SequenceGenerator(name = "sequenceMember", sequenceName = "PARKSHARK_MEMBER_SEQ", allocationSize = 1)
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @OneToMany(cascade = {PERSIST})
    @JoinColumn(name = "MEMBER_ID")
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    @Column(name = "EMAIL")
    private String email;

    @OneToMany
    @JoinColumn(name = "LICENSE_PLATE_ID")
    private List<LicensePlate> licensePlate = new ArrayList<>();

    @JoinColumn(name = "REGISTRATION_DATE",columnDefinition = "DATE")
    private LocalDate registrationDate;

    public Member() {
    }

    public Member(MemberBuilder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        address = builder.address;
        phoneNumbers = builder.phoneNumbers;
        email = builder.email;
        licensePlate = builder.licensePlate;
        registrationDate = LocalDate.now();
    }

    public static MemberBuilder memberBuilder() {
        return new MemberBuilder();
    }


    public static class MemberBuilder {
        private String firstName;
        private String lastName;
        private Address address;
        private List<PhoneNumber> phoneNumbers = new ArrayList<>();
        private String email;
        private List<LicensePlate> licensePlate = new ArrayList<>();

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

        public MemberBuilder withPhoneNumber(List<PhoneNumber> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
            return this;
        }

        public MemberBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public MemberBuilder withLicensePlate(List<LicensePlate> licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }


        public Member build() {
            return new Member(this);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getEmail() {
        return email;
    }

    public List<LicensePlate> getLicensePlate() {
        return licensePlate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public Long getId() {
        return id;
    }
}

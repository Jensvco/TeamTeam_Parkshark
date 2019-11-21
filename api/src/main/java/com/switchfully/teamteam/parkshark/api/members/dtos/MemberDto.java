package com.switchfully.teamteam.parkshark.api.members.dtos;

import com.switchfully.teamteam.parkshark.api.addresses.dto.AddressDto;
import com.switchfully.teamteam.parkshark.api.members.dtos.licenseplates.LicensePlateDto;
import com.switchfully.teamteam.parkshark.api.phone_numbers.PhoneNumberDto;
import com.switchfully.teamteam.parkshark.domain.memberships.Membership;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberDto {
    private Long id;
    private String firstName;
    private String lastName;
    private AddressDto address;
    private List<PhoneNumberDto> phoneNumbers = new ArrayList<>();
    private String email;
    private LicensePlateDto licensePlate;
    private LocalDate registrationDate;
    private Membership membership;

    public MemberDto(Long id,
                     String firstName,
                     String lastName,
                     AddressDto address,
                     List<PhoneNumberDto> phoneNumbers,
                     String email,
                     LicensePlateDto licensePlate,
                     LocalDate registrationDate,
                     Membership membership) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
        this.email = email;
        this.licensePlate = licensePlate;
        this.registrationDate = registrationDate;
        this.membership = membership;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public AddressDto getAddress() {
        return address;
    }

    public List<PhoneNumberDto> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getEmail() {
        return email;
    }

    public LicensePlateDto getLicensePlate() {
        return licensePlate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public Membership getMembership() {
        return membership;
    }
}

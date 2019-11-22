package com.switchfully.teamteam.parkshark.api.members.dtos;

import com.switchfully.teamteam.parkshark.api.addresses.dto.AddressDto;
import com.switchfully.teamteam.parkshark.api.phone_numbers.PhoneNumberDto;
import com.switchfully.teamteam.parkshark.domain.memberships.MembershipType;

import java.util.ArrayList;
import java.util.List;

public class CreateMemberDto {
    private String firstName;
    private String lastName;
    private AddressDto address;
    private List<PhoneNumberDto> phoneNumbers;
    private String email;
    private String licensePlateNumber;
    private String licensePlateIssuingCountry;
    private MembershipType membershipType;

    public CreateMemberDto(String firstName,
                           String lastName,
                           AddressDto address,
                           List<PhoneNumberDto> phoneNumbers,
                           String email,
                           String licensePlateNumber,
                           String licensePlateIssuingCountry,
                           MembershipType membershipType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
        this.email = email;
        this.licensePlateNumber = licensePlateNumber;
        this.licensePlateIssuingCountry = licensePlateIssuingCountry;
        this.membershipType = membershipType;
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

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public String getLicensePlateIssuingCountry() {
        return licensePlateIssuingCountry;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }
}

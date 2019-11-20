package com.switchfully.teamteam.parkshark.api.members.dtos;

import com.switchfully.teamteam.parkshark.api.addresses.dto.AddressDto;
import com.switchfully.teamteam.parkshark.api.phone_numbers.PhoneNumberDto;
import com.switchfully.teamteam.parkshark.domain.memberships.types.MembershipType;

import java.util.ArrayList;
import java.util.List;

public class CreateMemberDto {

    private String firstName;
    private String lastName;
    private AddressDto address;
    private List<PhoneNumberDto> phoneNumbers = new ArrayList<>();
    private String email;
    private String licensePlateNumber;
    private String licensePlateIssuingCountry;
    private MembershipType membershipType;

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    AddressDto getAddress() {
        return address;
    }

    List<PhoneNumberDto> getPhoneNumbers() {
        return phoneNumbers;
    }

    String getEmail() {
        return email;
    }

    String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    String getLicensePlateIssuingCountry() {
        return licensePlateIssuingCountry;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public CreateMemberDto withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CreateMemberDto withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CreateMemberDto withAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    public CreateMemberDto withPhoneNumbers(List<PhoneNumberDto> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
        return this;
    }

    public CreateMemberDto withEmail(String email) {
        this.email = email;
        return this;
    }

    public CreateMemberDto withLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
        return this;
    }

    public CreateMemberDto withLicensePlateIssuingCountry(String licensePlateIssuingCountry) {
        this.licensePlateIssuingCountry = licensePlateIssuingCountry;
        return this;
    }

    public CreateMemberDto withMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
        return this;
    }

}

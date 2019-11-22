package com.switchfully.teamteam.parkshark.api.members.dtos;

import com.switchfully.teamteam.parkshark.api.members.dtos.licenseplates.OverviewLicensePlateDto;
import com.switchfully.teamteam.parkshark.api.phone_numbers.PhoneNumberDto;
import com.switchfully.teamteam.parkshark.domain.memberships.MembershipType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OverviewMemberDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private List<PhoneNumberDto> phoneNumbers;
    private String email;
    private OverviewLicensePlateDto licensePlate;
    private LocalDate registrationDate;
    private MembershipType membershipType;

    public OverviewMemberDto(Integer id,
                             String firstName,
                             String lastName,
                             List<PhoneNumberDto> phoneNumbers,
                             String email,
                             OverviewLicensePlateDto licensePlate,
                             LocalDate registrationDate,
                             MembershipType membershipType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumbers = phoneNumbers;
        this.email = email;
        this.licensePlate = licensePlate;
        this.registrationDate = registrationDate;
        this.membershipType = membershipType;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<PhoneNumberDto> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getEmail() {
        return email;
    }

    public OverviewLicensePlateDto getLicensePlate() {
        return licensePlate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }
}

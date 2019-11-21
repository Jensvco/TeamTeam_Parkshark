package com.switchfully.teamteam.parkshark.api.members.dtos;

import com.switchfully.teamteam.parkshark.api.members.dtos.licenseplates.OverviewLicensePlateDto;
import com.switchfully.teamteam.parkshark.api.phone_numbers.PhoneNumberDto;
import com.switchfully.teamteam.parkshark.domain.memberships.Membership;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OverviewMemberDto {
    private Long id;
    private String firstName;
    private String lastName;
    private List<PhoneNumberDto> phoneNumbers = new ArrayList<>();
    private String email;
    private OverviewLicensePlateDto licensePlate;
    private LocalDate registrationDate;
    private Membership membership;

    public OverviewMemberDto(Long id,
                             String firstName,
                             String lastName,
                             List<PhoneNumberDto> phoneNumbers,
                             String email,
                             OverviewLicensePlateDto licensePlate,
                             LocalDate registrationDate,
                             Membership membership) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public Membership getMembership() {
        return membership;
    }
}

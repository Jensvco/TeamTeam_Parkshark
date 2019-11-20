package com.switchfully.teamteam.parkshark.api.members.dtos;

import com.switchfully.teamteam.parkshark.api.members.dtos.licenseplates.OverviewLicensePlateDto;
import com.switchfully.teamteam.parkshark.api.phone_numbers.PhoneNumberDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OverviewMemberDto {
    private Long id;
    private String firstName;
    private String lastName;
    private List<PhoneNumberDto> phoneNumbers = new ArrayList<>();
    private String email;
    private List<OverviewLicensePlateDto> licensePlates;
    private LocalDate registrationDate;

    public OverviewMemberDto(Long id, String firstName, String lastName, List<PhoneNumberDto> phoneNumbers, String email, List<OverviewLicensePlateDto> licensePlates, LocalDate registrationDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumbers = phoneNumbers;
        this.email = email;
        this.licensePlates = licensePlates;
        this.registrationDate = registrationDate;
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

    public List<OverviewLicensePlateDto> getLicensePlates() {
        return licensePlates;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
}

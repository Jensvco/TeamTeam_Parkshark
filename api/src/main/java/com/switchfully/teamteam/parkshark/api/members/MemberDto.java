package com.switchfully.teamteam.parkshark.api.members;

import com.switchfully.teamteam.parkshark.api.addresses.dto.AddressDto;
import com.switchfully.teamteam.parkshark.api.phone_numbers.PhoneNumberDto;

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

    public MemberDto(Long id, String firstName, String lastName, AddressDto address, List<PhoneNumberDto> phoneNumbers, String email, LicensePlateDto licensePlate, LocalDate registrationDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
        this.email = email;
        this.licensePlate = licensePlate;
        this.registrationDate = registrationDate;
    }
}

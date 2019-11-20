package com.switchfully.teamteam.parkshark.api.contact_persons.dto;

import com.switchfully.teamteam.parkshark.api.addresses.dto.CreateAddressDto;
import com.switchfully.teamteam.parkshark.api.phone_numbers.CreatePhoneNumberDto;

import java.util.List;

public class CreateContactPersonDto {
    private String name;
    private List<CreatePhoneNumberDto> phoneNumbers;
    private String email;
    private CreateAddressDto address;

    public CreateContactPersonDto() {
    }

    public CreateContactPersonDto(String name, List<CreatePhoneNumberDto> phoneNumbers, String email, CreateAddressDto address) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public List<CreatePhoneNumberDto> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getEmail() {
        return email;
    }

    public CreateAddressDto getAddress() {
        return address;
    }
}

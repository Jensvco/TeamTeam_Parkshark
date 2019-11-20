package com.switchfully.teamteam.parkshark.api.contact_persons.dto;

import com.switchfully.teamteam.parkshark.api.addresses.dto.AddressDto;
import com.switchfully.teamteam.parkshark.api.phone_numbers.PhoneNumberDto;

import java.util.List;

public class ContactPersonDto {
    private int id;
    private String name;
    private List<PhoneNumberDto> phoneNumbers;
    private String email;
    private AddressDto address;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<PhoneNumberDto> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getEmail() {
        return email;
    }

    public AddressDto getAddress() {
        return address;
    }

    public ContactPersonDto(int id, String name, List<PhoneNumberDto> phoneNumbers, String email, AddressDto address) {
        this.id = id;
        this.name = name;
        this.phoneNumbers = phoneNumbers;
        this.email = email;
        this.address = address;
    }
}

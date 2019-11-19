package com.switchfully.teamteam.parkshark.api.phone_numbers;

import com.switchfully.teamteam.parkshark.domain.PhoneNumber;

public class PhoneNumberDto {
    private int id;
    private String phoneNumber;
    private PhoneNumber.PhoneNumberType phoneNumberType;

    public PhoneNumberDto(int id, String phoneNumber, PhoneNumber.PhoneNumberType phoneNumberType) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.phoneNumberType = phoneNumberType;
    }

    public int getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PhoneNumber.PhoneNumberType getPhoneNumberType() {
        return phoneNumberType;
    }
}

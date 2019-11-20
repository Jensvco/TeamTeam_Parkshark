package com.switchfully.teamteam.parkshark.api.phone_numbers;

import com.switchfully.teamteam.parkshark.domain.PhoneNumber;

public class CreatePhoneNumberDto {
    private String phoneNumber;
    private PhoneNumber.PhoneNumberType phoneNumberType;

    public CreatePhoneNumberDto(String phoneNumber, PhoneNumber.PhoneNumberType phoneNumberType) {
        this.phoneNumber = phoneNumber;
        this.phoneNumberType = phoneNumberType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PhoneNumber.PhoneNumberType getPhoneNumberType() {
        return phoneNumberType;
    }
}

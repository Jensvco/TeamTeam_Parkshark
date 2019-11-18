package com.switchfully.teamteam.parkshark.domain;

public class PhoneNumber {
    private int id;
    private String phoneNumber;

    private enum phoneNumberType {
        MOBILE_PHONE,
        LAND_LINE
    }

    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

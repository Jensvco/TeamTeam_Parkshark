package com.switchfully.teamteam.parkshark.domain;

public class PhoneNumber {
    private int id;
    private String phoneNumber;

    private enum phoneNumberType {
        MOBILE_PHONE,
        LAND_LINE
    }

    public PhoneNumber(int id, String phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
    }
}

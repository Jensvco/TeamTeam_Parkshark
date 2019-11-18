package com.switchfully.teamteam.parkshark.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PHONE_NUMBER")
public class PhoneNumber {
    @Id
    private int id;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "PHONE_NUMBER_TYPE")
    private PhoneNumberType phoneNumberType;

    public enum PhoneNumberType {
        MOBILE_PHONE,
        LAND_LINE
    }

    public PhoneNumber(String phoneNumber, PhoneNumberType phoneNumberType) {
        this.phoneNumber = phoneNumber;
        this.phoneNumberType = phoneNumberType;
    }
}

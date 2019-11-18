package com.switchfully.teamteam.parkshark.domain;

import javax.persistence.*;

@Entity
@Table(name = "PHONE_NUMBER")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
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

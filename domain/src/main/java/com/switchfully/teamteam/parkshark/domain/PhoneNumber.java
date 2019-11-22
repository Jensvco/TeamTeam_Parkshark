package com.switchfully.teamteam.parkshark.domain;

import javax.persistence.*;

@Entity
@Table(name = "PHONE_NUMBER")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencePhoneNumber")
    @SequenceGenerator(name = "sequencePhoneNumber", sequenceName = "PARKSHARK_PHONENUMBER_SEQ", allocationSize = 1)
    private int id;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "PHONE_NUMBER_TYPE")
    private PhoneNumberType phoneNumberType;

    /* Required by JPA */
    private PhoneNumber() {
    }

    public PhoneNumber(String phoneNumber, PhoneNumberType phoneNumberType) {
        this.phoneNumber = phoneNumber;
        this.phoneNumberType = phoneNumberType;
    }

    public int getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PhoneNumberType getPhoneNumberType() {
        return phoneNumberType;
    }

    public enum PhoneNumberType {
        MOBILE_PHONE,
        LAND_LINE
    }
}

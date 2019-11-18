package com.switchfully.teamteam.parkshark.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactPersonTest {
    @Test
    void parkingLotBuilderTest() {
        PhoneNumber phoneNumber = new PhoneNumber("0474552266");
        ContactPerson contactPerson = new ContactPerson.Builder()
                .withName("Tim")
                .withEmail("Timmyboy@hotmail.com")
                .withPhoneNumber(phoneNumber)
                .build();

        Assertions.assertThat(contactPerson.getName().equals("Tim"));
        Assertions.assertThat(contactPerson.getEmail().equals("Timmyboy@hotmail.com"));
        Assertions.assertThat(contactPerson.getPhoneNumber().equals(phoneNumber));
    }
}
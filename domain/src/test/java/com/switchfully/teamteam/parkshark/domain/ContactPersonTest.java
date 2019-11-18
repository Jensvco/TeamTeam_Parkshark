package com.switchfully.teamteam.parkshark.domain;

import com.switchfully.teamteam.parkshark.domain.models.ContactPerson;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ContactPersonTest {
    @Test
    void parkingLotBuilderTest() {
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        PhoneNumber phoneNumber = new PhoneNumber("0474552266", PhoneNumber.PhoneNumberType.MOBILE_PHONE);
        phoneNumbers.add(phoneNumber);
        ContactPerson contactPerson = new ContactPerson.Builder()
                .withName("Tim")
                .withEmail("Timmyboy@hotmail.com")
                .withPhoneNumber(phoneNumbers)
                .build();

        Assertions.assertThat(contactPerson.getName().equals("Tim"));
        Assertions.assertThat(contactPerson.getEmail().equals("Timmyboy@hotmail.com"));
        Assertions.assertThat(contactPerson.getPhoneNumbers().contains(phoneNumber));
    }
}
package com.switchfully.teamteam.parkshark.domain.models;

import com.switchfully.teamteam.parkshark.domain.Address;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactPersonTest {

    @Test
    void memberBuilderTest() {
        Address address = new Address.Builder()
                .withCity("Aalter")
                .withHouseNumber("50")
                .withStreetName("Bosstraat")
                .build();

        Assertions.assertThat(address.getCity().equals("Aalter"));
        Assertions.assertThat(address.getHouseNumber().equals("50"));
        Assertions.assertThat(address.getStreetName().equals("Bosstraat"));
    }

}
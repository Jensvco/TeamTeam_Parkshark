package com.switchfully.teamteam.parkshark.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AddressTest {
    @Test
    void addressBuilderTest() {
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
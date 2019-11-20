package com.switchfully.teamteam.parkshark.domain.members;

import com.switchfully.teamteam.parkshark.domain.Address;
import com.switchfully.teamteam.parkshark.domain.members.license_plates.LicensePlate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {


    @Test
    void memberBuilderTest() {

        Address address = new Address.Builder()
                .withCity("Aalter")
                .withHouseNumber("50")
                .withStreetName("Bosstraat")
                .build();

        LicensePlate licensePlate = new LicensePlate("123-abc", "BE");


        Member member = Member.memberBuilder()
                .withFirstName("firstyname")
                .withLastName("lastyname")
                .withAddress(address)
                .withEmail("boe@boe.be")
                .withLicensePlate(Arrays.asList(licensePlate))
                .build();


        Assertions.assertThat(member.getEmail().equals("boe@boe.be"));
        Assertions.assertThat(member.getLicensePlate().equals(new LicensePlate("123-abc", "BE")));
        Assertions.assertThat(member.getAddress().getHouseNumber().equals("50"));
    }

}
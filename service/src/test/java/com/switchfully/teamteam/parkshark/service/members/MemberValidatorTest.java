package com.switchfully.teamteam.parkshark.service.members;

import com.switchfully.teamteam.parkshark.domain.Address;
import com.switchfully.teamteam.parkshark.domain.PhoneNumber;
import com.switchfully.teamteam.parkshark.domain.members.Member;
import com.switchfully.teamteam.parkshark.domain.members.Member.MemberBuilder;
import com.switchfully.teamteam.parkshark.domain.members.license_plates.LicensePlate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.switchfully.teamteam.parkshark.domain.members.Member.memberBuilder;
import static org.assertj.core.api.Assertions.assertThat;

public class MemberValidatorTest {

    private MemberBuilder memberBuilder;
    private MemberValidator memberValidator;

    @BeforeEach
    void setUp() {
        memberValidator = new MemberValidator();

        Address address = new Address.Builder()
                .withCity("Aalter")
                .withHouseNumber("50")
                .withStreetName("Bosstraat")
                .build();

        LicensePlate licensePlate = new LicensePlate("123-abc", "BE");

        memberBuilder = memberBuilder().withFirstName("yey").withLastName("sdf").withAddress(address)
                .withLicensePlate(licensePlate).withEmail("empty");
    }

    @Test
    void isValidForCreation_happyPath() {
        assertThat(memberValidator.isValidForCreation(memberBuilder
                .build()))
                .isTrue();
    }

    @Test
    void isValidForCreation_givenNullFirstName_thenNotValidForCreation() {
        assertThat(memberValidator.isValidForCreation(memberBuilder
                .withFirstName(null)
                .build()))
                .isFalse();
    }

    @Test
    void isValidForCreation_givenEmptyFirstName_thenNotValidForCreation() {
        assertThat(memberValidator.isValidForCreation(memberBuilder
                .withLastName("")
                .build()))
                .isFalse();
    }

    @Test
    void isValidForCreation_givenNullLastName_thenNotValidForCreation() {
        assertThat(memberValidator.isValidForCreation(memberBuilder
                .withLastName(null)
                .build()))
                .isFalse();
    }

    @Test
    void isValidForCreation_givenEmptyLastName_thenNotValidForCreation() {
        assertThat(memberValidator.isValidForCreation(memberBuilder
                .withLastName("")
                .build()))
                .isFalse();
    }

}

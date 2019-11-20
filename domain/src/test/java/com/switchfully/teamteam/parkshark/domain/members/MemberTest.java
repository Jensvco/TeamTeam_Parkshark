package com.switchfully.teamteam.parkshark.domain.members;

import com.switchfully.teamteam.parkshark.domain.members.license_plates.LicensePlate;
import com.switchfully.teamteam.parkshark.domain.memberships.BronzeMembership;
import com.switchfully.teamteam.parkshark.domain.memberships.GoldMembership;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.switchfully.teamteam.parkshark.domain.Address.Builder.address;
import static com.switchfully.teamteam.parkshark.domain.members.Member.MemberBuilder;
import static com.switchfully.teamteam.parkshark.domain.members.Member.MemberBuilder.member;
import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {

    private MemberBuilder member;

    @BeforeEach
    void setUp() {
        member = member()
                .withFirstName("Bruce")
                .withLastName("Wayne")
                .withAddress(address()
                        .withCity("Aalter")
                        .withHouseNumber("50")
                        .withStreetName("Bosstraat")
                        .withPostalCode("1000")
                        .build())
                .withEmail("boe@boe.be")
                .withLicensePlate(new LicensePlate("123-abc", "BE"));
    }

    @Test
    void createMember() {
        var createdMember = member.build();

        assertThat(createdMember.getFirstName()).isEqualTo("Bruce");
        assertThat(createdMember.getLastName()).isEqualTo("Wayne");
        assertThat(createdMember.getAddress().getCity()).isEqualTo("Aalter");
        assertThat(createdMember.getAddress().getHouseNumber()).isEqualTo("50");
        assertThat(createdMember.getAddress().getStreetName()).isEqualTo("Bosstraat");
        assertThat(createdMember.getAddress().getPostalCode()).isEqualTo("1000");
        assertThat(createdMember.getEmail()).isEqualTo("boe@boe.be");
        assertThat(createdMember.getLicensePlate().getNumber()).isEqualTo("123-abc");
        assertThat(createdMember.getLicensePlate().getIssuingCountry()).isEqualTo("BE");
    }

    @Test
    void createMember_withoutMembership_thenMembershipShouldBeBronze() {
        var createdMember = member.build();

        assertThat(createdMember.getMembership()).isInstanceOf(BronzeMembership.class);
    }

    @Test
    void createMember_withMembership_thenMembershipShouldAssigned() {
        var createdMember = member.withMembership(new GoldMembership()).build();

        assertThat(createdMember.getMembership()).isInstanceOf(GoldMembership.class);
    }

}
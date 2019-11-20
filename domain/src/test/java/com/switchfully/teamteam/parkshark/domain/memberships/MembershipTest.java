package com.switchfully.teamteam.parkshark.domain.memberships;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class MembershipTest {

    @Test
    void createMembership_thenMembershipShouldHaveTodayAsStartingDate() {
        var membership = new BronzeMembership();

        assertThat(membership.getStartingDate()).isEqualTo(LocalDate.now());
    }

}
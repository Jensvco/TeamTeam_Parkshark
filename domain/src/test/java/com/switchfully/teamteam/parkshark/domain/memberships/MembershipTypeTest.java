package com.switchfully.teamteam.parkshark.domain.memberships;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.switchfully.teamteam.parkshark.domain.memberships.MembershipType.BRONZE;
import static org.assertj.core.api.Assertions.assertThat;

class MembershipTypeTest {

    @Test
    void createMembership_thenMembershipShouldHaveTodayAsStartingDate() {
        var membership = new Membership(BRONZE);

        assertThat(membership.getStartingDate()).isEqualTo(LocalDate.now());
    }

}
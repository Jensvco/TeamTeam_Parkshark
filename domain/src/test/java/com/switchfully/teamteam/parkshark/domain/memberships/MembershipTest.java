package com.switchfully.teamteam.parkshark.domain.memberships;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.switchfully.teamteam.parkshark.domain.memberships.Membership.BRONZE;
import static org.assertj.core.api.Assertions.assertThat;

class MembershipTest {

    @Test
    void createMembership_thenMembershipShouldHaveTodayAsStartingDate() {
        var membership = BRONZE;

        assertThat(membership.getStartingDate()).isEqualTo(LocalDate.now());
    }

}
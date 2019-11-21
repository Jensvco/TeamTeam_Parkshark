package com.switchfully.teamteam.parkshark.domain.memberships;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Enumerated;
import javax.persistence.Transient;
import java.time.LocalDate;

import static javax.persistence.EnumType.STRING;

@Embeddable
public class Membership {

    @Enumerated(STRING)
    @Column(name = "MEMBERSHIP")
    private MembershipType type;

    @Transient
    private LocalDate startingDate;

    public Membership(MembershipType type) {
        this.type = type;
        this.startingDate = LocalDate.now();
    }

    public MembershipType getType() {
        return type;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

}

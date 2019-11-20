package com.switchfully.teamteam.parkshark.domain.memberships;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.time.LocalDate;

@Embeddable
public abstract class Membership {

    @Column(name = "MEMBERSHIP")
    private MembershipType membershipType;

    @Transient private double monthlyCost;
    @Transient private double allocationReduction;
    @Transient private int maximumAllowedAllocationHours;
    @Transient private LocalDate startingDate;

    public Membership(double monthlyCost,
                      double allocationReduction,
                      int maximumAllowedAllocationHours) {
        this.monthlyCost = monthlyCost;
        this.allocationReduction = allocationReduction;
        this.maximumAllowedAllocationHours = maximumAllowedAllocationHours;
        this.startingDate = LocalDate.now();
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public double getAllocationReduction() {
        return allocationReduction;
    }

    public int getMaximumAllowedAllocationHours() {
        return maximumAllowedAllocationHours;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

}

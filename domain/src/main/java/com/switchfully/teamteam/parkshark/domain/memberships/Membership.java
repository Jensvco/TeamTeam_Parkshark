package com.switchfully.teamteam.parkshark.domain.memberships;

import java.time.LocalDate;

public enum Membership {

    BRONZE(0.0, 0.0, 4),
    SILVER(10.0, 0.2, 6),
    GOLD(40.0, 0.3, 24);

    private double monthlyCost;
    private double allocationReduction;
    private int maximumAllowedAllocationHours;
    private LocalDate startingDate;

    Membership(double monthlyCost,
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

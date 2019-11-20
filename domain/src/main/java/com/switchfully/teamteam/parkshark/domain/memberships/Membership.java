package com.switchfully.teamteam.parkshark.domain.memberships;

import java.time.LocalDate;

public abstract class Membership {

    private double monthlyCost;
    private double allocationReduction;
    private int maximumAllowedAllocationHours;
    private LocalDate startingDate;

    public Membership(double monthlyCost, double allocationReduction, int maximumAllowedAllocationHours) {
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

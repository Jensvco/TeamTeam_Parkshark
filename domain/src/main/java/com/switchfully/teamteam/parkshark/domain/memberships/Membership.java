package com.switchfully.teamteam.parkshark.domain.memberships;

public abstract class Membership {

    private double monthlyCost;
    private double allocationReduction;
    private int maximumAllowedAllocationHours;

    public Membership(double monthlyCost, double allocationReduction, int maximumAllowedAllocationHours) {
        this.monthlyCost = monthlyCost;
        this.allocationReduction = allocationReduction;
        this.maximumAllowedAllocationHours = maximumAllowedAllocationHours;
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

}

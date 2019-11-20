package com.switchfully.teamteam.parkshark.domain.memberships;

public class BronzeMembership extends Membership {

    public static final double MONTHLY_COST = 0.0;
    public static final double ALLOCATION_REDUCTION = 0.0;
    public static final int MAXIMUM_ALLOWED_ALLOCATION_HOURS = 4;

    public BronzeMembership() {
        super(MONTHLY_COST, ALLOCATION_REDUCTION, MAXIMUM_ALLOWED_ALLOCATION_HOURS);
    }

}

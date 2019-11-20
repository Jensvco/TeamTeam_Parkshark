package com.switchfully.teamteam.parkshark.domain.memberships;

public class SilverMembership extends Membership {

    public static final double MONTHLY_COST = 10.0;
    public static final double ALLOCATION_REDUCTION = 0.2;
    public static final int MAXIMUM_ALLOWED_ALLOCATION_HOURS = 6;

    public SilverMembership() {
        super(MONTHLY_COST, ALLOCATION_REDUCTION, MAXIMUM_ALLOWED_ALLOCATION_HOURS);
    }

}

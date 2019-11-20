package com.switchfully.teamteam.parkshark.domain.memberships;

public class GoldMembership extends Membership {

    public static final double MONTHLY_COST = 40.0;
    public static final double ALLOCATION_REDUCTION = 0.3;
    public static final int MAXIMUM_ALLOWED_ALLOCATION_HOURS = 24;

    public GoldMembership() {
        super(MONTHLY_COST, ALLOCATION_REDUCTION, MAXIMUM_ALLOWED_ALLOCATION_HOURS);
    }

}

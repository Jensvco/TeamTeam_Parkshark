package com.switchfully.teamteam.parkshark.api.parking_spots;

import com.switchfully.teamteam.parkshark.service.members.MemberService;

public class CreateParkingSpotDto {

    private String licensePlateNumber;
    private int memberId;
    private int parkingLotId;

    private CreateParkingSpotDto() {
    }

    public CreateParkingSpotDto(MemberService memberService, String licensePlateNumber, int memberId, int parkingLotId) {
        this.licensePlateNumber = licensePlateNumber;
        this.memberId = memberId;
        this.parkingLotId = parkingLotId;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

}

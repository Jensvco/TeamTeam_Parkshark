package com.switchfully.teamteam.parkshark.api.parking_spots;

import com.switchfully.teamteam.parkshark.domain.members.Member;
import com.switchfully.teamteam.parkshark.service.members.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class CreateParkingSpotDto {


    private String licensePlateNumber;
    private int memberId;
    private int  parkingLotId;

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

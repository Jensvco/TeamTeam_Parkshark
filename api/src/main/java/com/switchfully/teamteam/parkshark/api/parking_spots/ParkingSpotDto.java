package com.switchfully.teamteam.parkshark.api.parking_spots;

import com.switchfully.teamteam.parkshark.api.members.dtos.MemberDto;
import com.switchfully.teamteam.parkshark.api.members.dtos.licenseplates.LicensePlateDto;
import com.switchfully.teamteam.parkshark.api.parking_lots.ParkingLotDto;

import java.time.LocalDateTime;

public class ParkingSpotDto {

    private String id;
    private LicensePlateDto licensePlate;
    private MemberDto member;
    private ParkingLotDto parkingLot;
    private LocalDateTime startSession;
    private LocalDateTime stopSession;

    public ParkingSpotDto() {
    }

    public ParkingSpotDto(String id, LicensePlateDto licensePlate, MemberDto member, ParkingLotDto parkingLot, LocalDateTime startSession, LocalDateTime stopSession) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.member = member;
        this.parkingLot = parkingLot;
        this.startSession = startSession;
        this.stopSession = stopSession;
    }

    public String getId() {
        return id;
    }

    public LicensePlateDto getLicensePlate() {
        return licensePlate;
    }

    public MemberDto getMember() {
        return member;
    }

    public ParkingLotDto getParkingLot() {
        return parkingLot;
    }

    public LocalDateTime getStartSession() {
        return startSession;
    }

    public LocalDateTime getStopSession() {
        return stopSession;
    }
}

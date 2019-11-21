package com.switchfully.teamteam.parkshark.domain;

import com.switchfully.teamteam.parkshark.domain.members.Member;
import com.switchfully.teamteam.parkshark.domain.members.license_plates.LicensePlate;
import com.switchfully.teamteam.parkshark.domain.models.ParkingLot;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class ParkingSpot {

    @Id
    private String id;

    @OneToOne
    @JoinColumn(name = "LICENSE_PLATE_ID")
    private LicensePlate licensePlate;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "PARKING_LOT_ID")
    private ParkingLot parkingLot;

    @Column(name="START_SESSION")
    private LocalDateTime startSession;
    @Column(name="STOP_SESSION")
    private LocalDateTime stopSession;

    public ParkingSpot() {
    }

    public ParkingSpot(LicensePlate licensePlate, Member member, ParkingLot parkingLot) {
        this.id= UUID.randomUUID().toString();
        this.licensePlate = licensePlate;
        this.member = member;
        this.parkingLot = parkingLot;
        this.startSession = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public Member getMember() {
        return member;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public LocalDateTime getStartSession() {
        return startSession;
    }

    public LocalDateTime getStopSession() {
        return stopSession;
    }

    public void setStopSession(LocalDateTime stopSession) {
        this.stopSession = stopSession;
    }
}

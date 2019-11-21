package com.switchfully.teamteam.parkshark.domain;

import com.switchfully.teamteam.parkshark.domain.members.Member;
import com.switchfully.teamteam.parkshark.domain.members.license_plates.LicensePlate;
import com.switchfully.teamteam.parkshark.domain.models.ParkingLot;

import javax.persistence.*;
import java.time.LocalDateTime;

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


    public ParkingSpot(LicensePlate licensePlate, Member member, ParkingLot parkingLot, LocalDateTime startSession, LocalDateTime stopSession) {
        this.licensePlate = licensePlate;
        this.member = member;
        this.parkingLot = parkingLot;
        this.startSession = startSession;
        this.stopSession = stopSession;
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
}

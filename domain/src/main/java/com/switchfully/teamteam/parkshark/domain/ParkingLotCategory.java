package com.switchfully.teamteam.parkshark.domain;

import javax.persistence.*;

@Entity
@Table(name = "PARKING_LOT_CATEGORY")
public class ParkingLotCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    public ParkingLotCategory(String categoryName) {
        this.categoryName = categoryName;
    }
}

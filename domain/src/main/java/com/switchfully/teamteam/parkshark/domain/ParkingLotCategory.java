package com.switchfully.teamteam.parkshark.domain;

import javax.persistence.*;

@Entity
@Table(name = "PARKING_LOT_CATEGORY")
public class ParkingLotCategory {

    @Id
    //@GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "sequenceParkingLotCategory")
    //@SequenceGenerator(name = "sequenceParkingLotCategory", sequenceName = "PARKSHARK_PL_CATEGORY_SEQ", allocationSize = 1)
    private int id;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    /* Required by JPA */
    private ParkingLotCategory() {
    }

    public ParkingLotCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public ParkingLotCategory(int id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public ParkingLotCategory(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

}

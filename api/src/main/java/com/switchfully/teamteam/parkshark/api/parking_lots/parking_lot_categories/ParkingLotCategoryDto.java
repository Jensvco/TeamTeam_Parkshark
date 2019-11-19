package com.switchfully.teamteam.parkshark.api.parking_lots.parking_lot_categories;

public class ParkingLotCategoryDto {
    private int id;
    private String categoryName;

    public int getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public ParkingLotCategoryDto(int id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }
}

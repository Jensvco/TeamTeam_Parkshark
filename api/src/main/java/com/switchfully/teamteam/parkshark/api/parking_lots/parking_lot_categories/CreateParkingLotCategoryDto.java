package com.switchfully.teamteam.parkshark.api.parking_lots.parking_lot_categories;

public class CreateParkingLotCategoryDto {
    private int categoryId;

    public CreateParkingLotCategoryDto(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getId() {
        return categoryId;
    }

}

package com.switchfully.teamteam.parkshark.api.parking_lots.parking_lot_categories;

public class CreateParkingLotCategoryDto {
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public CreateParkingLotCategoryDto(String categoryName) {
        this.categoryName = categoryName;
    }
}

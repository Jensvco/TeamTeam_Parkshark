package com.switchfully.teamteam.parkshark.api.parking_lots.parking_lot_categories;

import com.switchfully.teamteam.parkshark.api.Mapper;
import com.switchfully.teamteam.parkshark.api.parking_lots.parking_lot_categories.CreateParkingLotCategoryDto;
import com.switchfully.teamteam.parkshark.api.parking_lots.parking_lot_categories.ParkingLotCategoryDto;
import com.switchfully.teamteam.parkshark.domain.ParkingLotCategory;

public class ParkingLotCategoryMapper implements Mapper<CreateParkingLotCategoryDto, ParkingLotCategoryDto, ParkingLotCategory> {
    @Override
    public ParkingLotCategory toDomain(CreateParkingLotCategoryDto createParkingLotCategoryDto) {
        return new ParkingLotCategory(createParkingLotCategoryDto.getCategoryName());
    }

    public ParkingLotCategory toDomain(ParkingLotCategoryDto parkingLotCategoryDto) {
        return new ParkingLotCategory(parkingLotCategoryDto.getId(),parkingLotCategoryDto.getCategoryName());
    }

    @Override
    public ParkingLotCategoryDto toDto(ParkingLotCategory parkingLotCategory) {
        return new ParkingLotCategoryDto(parkingLotCategory.getId(), parkingLotCategory.getCategoryName());
    }
}

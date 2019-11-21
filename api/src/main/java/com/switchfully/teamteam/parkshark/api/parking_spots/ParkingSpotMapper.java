package com.switchfully.teamteam.parkshark.api.parking_spots;

import com.switchfully.teamteam.parkshark.api.Mapper;
import com.switchfully.teamteam.parkshark.domain.ParkingSpot;

public class ParkingSpotMapper implements Mapper<CreateParkingSpotDto,ParkingSpotDto, ParkingSpot> {
    
    @Override
    public ParkingSpot toDomain(CreateParkingSpotDto createParkingSpotDto) {



    }

    @Override
    public ParkingSpotDto toDto(ParkingSpot parkingSpot) {
        return null;
    }
}




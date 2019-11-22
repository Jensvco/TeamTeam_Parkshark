package com.switchfully.teamteam.parkshark.api.parking_spots;

import com.switchfully.teamteam.parkshark.service.parking_spots.ParkingSpotService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/parkingspots")
public class ParkingSpotController {

    private ParkingSpotService parkingSpotService;
    private ParkingSpotMapper parkingSpotMapper;

    public ParkingSpotController(ParkingSpotService parkingSpotService, ParkingSpotMapper parkingSpotMapper) {
        this.parkingSpotService = parkingSpotService;
        this.parkingSpotMapper = parkingSpotMapper;
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingSpotDto createParkingSpot(CreateParkingSpotDto createParkingSpotDto) {
        return parkingSpotMapper.toDto(parkingSpotService.createParkingSpot(parkingSpotMapper.toDomain(createParkingSpotDto)));
    }


    @PutMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ParkingSpotDto stopParking(StopParkingSpotDto stopParkingSpotDto) {
        return parkingSpotMapper.toDto(parkingSpotService.stopParking(parkingSpotMapper.toDomain(stopParkingSpotDto)));

    }
}

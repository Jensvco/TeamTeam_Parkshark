package com.switchfully.teamteam.parkshark.api.parking_spots;

import com.switchfully.teamteam.parkshark.service.parking_spots.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/parkingspots")
public class ParkingSpotController {

    private ParkingSpotService parkingSpotService;
    private ParkingSpotMapper parkingSpotMapper;

    @Autowired
    public ParkingSpotController(ParkingSpotService parkingSpotService, ParkingSpotMapper parkingSpotMapper) {
        this.parkingSpotService = parkingSpotService;
        this.parkingSpotMapper = parkingSpotMapper;
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingSpotDto createParkingSpot(@RequestBody CreateParkingSpotDto createParkingSpotDto) {
        return parkingSpotMapper.toDto(parkingSpotService.createParkingSpot(parkingSpotMapper.toDomain(createParkingSpotDto)));
    }


    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ParkingSpotDto> findAllParkingSpots() {
        return parkingSpotService.findAllParkingSpots().stream().map(value -> parkingSpotMapper.toDto(value)).collect(Collectors.toList());
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ParkingSpotDto stopParking(@RequestBody StopParkingSpotDto stopParkingSpotDto) {
        return parkingSpotMapper.toDto(parkingSpotService.stopParking(parkingSpotMapper.toDomain(stopParkingSpotDto)));

    }
}

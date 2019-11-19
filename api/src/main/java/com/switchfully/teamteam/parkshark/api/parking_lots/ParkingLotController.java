package com.switchfully.teamteam.parkshark.api.parking_lots;

import com.switchfully.teamteam.parkshark.domain.models.ParkingLot;
import com.switchfully.teamteam.parkshark.service.parking_lots.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/parkinglots")
public class ParkingLotController {

    private ParkingLotService parkingLotService;
    private ParkingLotMapper parkingLotMapper;

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingLot createParkingLot(CreateParkingLotDto createParkingLotDto) {
        return parkingLotService.createParkingLot(parkingLotMapper.toDomain(createParkingLotDto));
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<ParkingLot> findAllParkingLots() {
        return parkingLotService.findAllParkingLots();
    }

    @GetMapping(path = "/{parkingLotId}", produces = "application/json")
    public ParkingLotDto getParkingLotById(@PathVariable int parkingLotId) {
        return parkingLotMapper.toDto(parkingLotService.findParkingLotById(parkingLotId));
    }
}

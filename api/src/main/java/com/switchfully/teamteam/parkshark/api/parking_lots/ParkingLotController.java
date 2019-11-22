package com.switchfully.teamteam.parkshark.api.parking_lots;

import com.switchfully.teamteam.parkshark.api.LoggingController;
import com.switchfully.teamteam.parkshark.service.parking_lots.ParkingLotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(path = "/" + ParkingLotController.PARKING_LOT_RESOURCE_NAME)
public class ParkingLotController {
    public static final String PARKING_LOT_RESOURCE_NAME = "parkinglots";

    private Logger logger = LoggerFactory.getLogger(LoggingController.class);

    private ParkingLotService parkingLotService;
    private ParkingLotMapper parkingLotMapper;

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService, ParkingLotMapper parkingLotMapper) {
        this.parkingLotService = parkingLotService;
        this.parkingLotMapper = parkingLotMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingLotDto createParkingLot(@RequestBody CreateParkingLotDto createParkingLotDto) {
        var createdParkingLot = parkingLotService.createParkingLot(parkingLotMapper.toDomain(createParkingLotDto));
        logger.info("Received call to create a parking lot with id " + createdParkingLot.getId());
        return parkingLotMapper.toDto(createdParkingLot);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ParkingLotDto> findAllParkingLots() {
        logger.info("Received call to fetch all parking lots");
        return parkingLotService.findAllParkingLots().stream()
                .map(parkingLot -> parkingLotMapper.toDto(parkingLot))
                .collect(toList());
    }

    @GetMapping(path = "/{parkingLotId}", produces = "application/json")
    public ParkingLotDto getParkingLotById(@PathVariable int parkingLotId) {
        logger.info("Received call to look up parking lot with id " + parkingLotId);
        return parkingLotMapper.toDto(parkingLotService.findParkingLotById(parkingLotId));
    }
}

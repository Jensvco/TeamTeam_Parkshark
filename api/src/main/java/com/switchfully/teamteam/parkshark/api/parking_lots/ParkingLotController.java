package com.switchfully.teamteam.parkshark.api.parking_lots;

import com.switchfully.teamteam.parkshark.api.phone_numbers.PhoneNumberMapper;
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
    private PhoneNumberMapper phoneNumberMapper;

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService, ParkingLotMapper parkingLotMapper, PhoneNumberMapper phoneNumberMapper) {
        this.parkingLotService = parkingLotService;
        this.parkingLotMapper = parkingLotMapper;
        this.phoneNumberMapper = phoneNumberMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingLot createParkingLot(@RequestBody CreateParkingLotDto createParkingLotDto) {
        //        parkingLotService.addPhoneNumbers(parkingLot.getContactPerson().getId(), createParkingLotDto.getContactPerson().getPhoneNumbers().stream().map(phoneNumberMapper::toDomain).collect(Collectors.toList()));
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

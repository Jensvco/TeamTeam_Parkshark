package com.switchfully.teamteam.parkshark.api.parking_lots;

import com.switchfully.teamteam.parkshark.api.Mapper;
import com.switchfully.teamteam.parkshark.api.addresses.dto.AddressMapper;
import com.switchfully.teamteam.parkshark.api.contact_persons.dto.ContactPersonMapper;
import com.switchfully.teamteam.parkshark.api.divisions.dtos.DivisionMapper;
import com.switchfully.teamteam.parkshark.domain.divisions.Division;
import com.switchfully.teamteam.parkshark.domain.models.ParkingLot;
import com.switchfully.teamteam.parkshark.service.divisions.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotMapper implements Mapper<CreateParkingLotDto, ParkingLotDto, ParkingLot> {

    private AddressMapper addressMapper;
    private ContactPersonMapper contactPersonMapper;
    private DivisionMapper divisionMapper;
    private DivisionService divisionService;

    @Autowired
    public ParkingLotMapper(AddressMapper addressMapper, ContactPersonMapper contactPersonMapper, DivisionMapper divisionMapper, DivisionService divisionService) {
        this.addressMapper = addressMapper;
        this.contactPersonMapper = contactPersonMapper;
        this.divisionMapper = divisionMapper;
        this.divisionService = divisionService;
    }

    @Override
    public ParkingLot toDomain(CreateParkingLotDto createParkingLotDto) {
        Division division = divisionService.findDivisionById(createParkingLotDto.getDivisionId());
        return new ParkingLot.Builder()
                .withContactPerson(contactPersonMapper.toDomain(createParkingLotDto.getContactPerson()))
                .withCapacity(createParkingLotDto.getCapacity())
                .withAddress(addressMapper.toDomain(createParkingLotDto.getAddress()))
                .withContactPerson(contactPersonMapper.toDomain(createParkingLotDto.getContactPerson()))
                .withPricePerHour(createParkingLotDto.getPricePerHour())
                .withName(createParkingLotDto.getName())
                .withDivision(division)
                .withParkingLotCategory(createParkingLotDto.getParkingLotCategory())
                .build();
    }

    @Override
    public ParkingLotDto toDto(ParkingLot parkingLot) {
        return new ParkingLotDto(parkingLot.getId()
                , parkingLot.getName()
                , parkingLot.getParkingLotCategory()
                , divisionMapper.toDto(parkingLot.getDivision())
                , parkingLot.getCapacity()
                , contactPersonMapper.toDto(parkingLot.getContactPerson())
                , addressMapper.toDto(parkingLot.getAddress())
                , parkingLot.getPricePerHour());
    }
}

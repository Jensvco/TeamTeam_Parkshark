package com.switchfully.teamteam.parkshark.api.parking_lots;

import com.switchfully.teamteam.parkshark.api.Mapper;
import com.switchfully.teamteam.parkshark.api.addresses.dto.AddressMapper;
import com.switchfully.teamteam.parkshark.api.contact_persons.dto.ContactPersonMapper;
import com.switchfully.teamteam.parkshark.api.parking_lots.parking_lot_categories.ParkingLotCategoryMapper;
import com.switchfully.teamteam.parkshark.domain.models.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotMapper implements Mapper<CreateParkingLotDto, ParkingLotDto, ParkingLot> {

    private AddressMapper addressMapper;
    private ParkingLotCategoryMapper parkingLotCategoryMapper;
    private ContactPersonMapper contactPersonMapper;

    @Autowired
    public ParkingLotMapper(AddressMapper addressMapper,
                            ParkingLotCategoryMapper parkingLotCategoryMapper,
                            ContactPersonMapper contactPersonMapper) {
        this.addressMapper = addressMapper;
        this.parkingLotCategoryMapper = parkingLotCategoryMapper;
        this.contactPersonMapper = contactPersonMapper;
    }

    @Override
    public ParkingLot toDomain(CreateParkingLotDto createParkingLotDto) {
        return new ParkingLot.Builder()
                .withCapacity(createParkingLotDto.getCapacity())
                .withAddress(addressMapper.toDomain(createParkingLotDto.getAddress()))
                .withName(createParkingLotDto.getName())
                .withParkingLotCategory(parkingLotCategoryMapper.toDomain(createParkingLotDto.getParkingLotCategory()))
                .build();
    }

    @Override
    public ParkingLotDto toDto(ParkingLot parkingLot) {
        return new ParkingLotDto(parkingLot.getId(), parkingLot.getName()
                , parkingLotCategoryMapper.toDto(parkingLot.getParkingLotCategory())
                , parkingLot.getCapacity()
                , contactPersonMapper.toDto(parkingLot.getContactPerson())
                , addressMapper.toDto(parkingLot.getAddress())
                , parkingLot.getPricePerHour());
    }
}

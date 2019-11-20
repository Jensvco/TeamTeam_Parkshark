package com.switchfully.teamteam.parkshark.api.addresses.dto;

import com.switchfully.teamteam.parkshark.api.Mapper;
import com.switchfully.teamteam.parkshark.domain.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements Mapper<CreateAddressDto, AddressDto, Address> {

    @Override
    public Address toDomain(CreateAddressDto createAddressDto) {
        return new Address.Builder()
                .withCity(createAddressDto.getCity())
                .withStreetName(createAddressDto.getStreetName())
                .withHouseNumber(createAddressDto.getHouseNumber())
                .withPostalCode(createAddressDto.getPostalCode())
                .withCity(createAddressDto.getCity())
                .build();
    }

    public Address toDomain(AddressDto addressDto) {
        return new Address.Builder()
                .withCity(addressDto.getCity())
                .withStreetName(addressDto.getStreetName())
                .withHouseNumber(addressDto.getHouseNumber())
                .withPostalCode(addressDto.getPostalCode())
                .withCity(addressDto.getCity())
                .build();
    }


    @Override
    public AddressDto toDto(Address address) {
        return new AddressDto(address.getId(), address.getStreetName(), address.getHouseNumber(), address.getPostalCode(), address.getCity());
    }
}

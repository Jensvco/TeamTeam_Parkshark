package com.switchfully.teamteam.parkshark.api.contact_persons.dto;

import com.switchfully.teamteam.parkshark.api.Mapper;
import com.switchfully.teamteam.parkshark.api.addresses.dto.AddressMapper;
import com.switchfully.teamteam.parkshark.api.phone_numbers.PhoneNumberMapper;
import com.switchfully.teamteam.parkshark.domain.models.ContactPerson;

import java.util.stream.Collectors;

public class ContactPersonMapper implements Mapper<CreateContactPersonDto, ContactPersonDto, ContactPerson> {

    private AddressMapper addressMapper;
    private PhoneNumberMapper phoneNumberMapper;


    @Override
    public ContactPerson toDomain(CreateContactPersonDto createContactPersonDto) {
        return new ContactPerson.Builder()
                .withAddress(addressMapper.toDomain(createContactPersonDto.getAddress()))
                .withEmail(createContactPersonDto.getEmail())
                .withName(createContactPersonDto.getName())
                .withPhoneNumber(createContactPersonDto.getPhoneNumbers().stream().map($value -> phoneNumberMapper.toDomain($value)).collect(Collectors.toList()))
                .build();
    }

    public ContactPerson toDomain(ContactPersonDto contactPersonDto) {
        return new ContactPerson.Builder()
                .withAddress(addressMapper.toDomain(contactPersonDto.getAddress()))
                .withEmail(contactPersonDto.getEmail())
                .withName(contactPersonDto.getName())
                .withPhoneNumber(contactPersonDto.getPhoneNumbers().stream().map($value -> phoneNumberMapper.toDomain($value)).collect(Collectors.toList()))
                .build();
    }

    @Override
    public ContactPersonDto toDto(ContactPerson contactPerson) {
        return new ContactPersonDto(contactPerson.getId()
                , contactPerson.getName()
                , contactPerson.getPhoneNumbers().stream().map($value -> phoneNumberMapper.toDto($value)).collect(Collectors.toList())
                , contactPerson.getEmail()
                , addressMapper.toDto(contactPerson.getAddress()));
    }
}

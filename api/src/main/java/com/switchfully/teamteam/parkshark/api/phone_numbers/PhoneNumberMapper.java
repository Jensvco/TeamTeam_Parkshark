package com.switchfully.teamteam.parkshark.api.phone_numbers;

import com.switchfully.teamteam.parkshark.api.Mapper;
import com.switchfully.teamteam.parkshark.domain.PhoneNumber;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberMapper implements Mapper<CreatePhoneNumberDto,PhoneNumberDto, PhoneNumber> {

    @Override
    public PhoneNumber toDomain(CreatePhoneNumberDto createPhoneNumberDto) {
        return new PhoneNumber(createPhoneNumberDto.getPhoneNumber(),createPhoneNumberDto.getPhoneNumberType());
    }

    public PhoneNumber toDomain(PhoneNumberDto phoneNumberDto) {
        return new PhoneNumber(phoneNumberDto.getPhoneNumber(),phoneNumberDto.getPhoneNumberType());
    }

    @Override
    public PhoneNumberDto toDto(PhoneNumber phoneNumber) {
        return new PhoneNumberDto(phoneNumber.getId(),phoneNumber.getPhoneNumber(),phoneNumber.getPhoneNumberType());
    }
}

package com.switchfully.teamteam.parkshark.api.members.dtos.licenseplates;

import com.switchfully.teamteam.parkshark.api.Mapper;
import com.switchfully.teamteam.parkshark.domain.members.license_plates.LicensePlate;
import org.springframework.stereotype.Component;

@Component
public class LicensePlateMapper implements Mapper<CreateLicensePlateDto,LicensePlateDto, LicensePlate> {

    @Override
    public LicensePlate toDomain(CreateLicensePlateDto createLicensePlateDto) {
        return new LicensePlate(createLicensePlateDto.getNumber(),createLicensePlateDto.getIssuingCountry());
    }

    public LicensePlate toDomain(LicensePlateDto licensePlate) {
        return new LicensePlate(licensePlate.getNumber(),licensePlate.getIssuingCountry());
    }

    public OverviewLicensePlateDto toOverviewDto(LicensePlate licensePlate){
        return new OverviewLicensePlateDto(licensePlate.getNumber());
    }

    @Override
    public LicensePlateDto toDto(LicensePlate licensePlate) {
        return new LicensePlateDto(licensePlate.getId(),licensePlate.getNumber(),licensePlate.getIssuingCountry());
    }
}

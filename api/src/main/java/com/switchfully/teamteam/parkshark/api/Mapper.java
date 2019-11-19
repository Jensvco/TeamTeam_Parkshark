package com.switchfully.teamteam.parkshark.api;

public interface Mapper<CREATE_DTO, DTO, DOMAIN> {

    DOMAIN toDomain(CREATE_DTO dto);

    DTO toDto(DOMAIN domain);

}

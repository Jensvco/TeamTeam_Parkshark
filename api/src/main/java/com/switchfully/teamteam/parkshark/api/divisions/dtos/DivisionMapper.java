package com.switchfully.teamteam.parkshark.api.divisions.dtos;

import com.switchfully.teamteam.parkshark.api.Mapper;
import com.switchfully.teamteam.parkshark.api.directors.dtos.DirectorMapper;
import com.switchfully.teamteam.parkshark.domain.divisions.Division;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.switchfully.teamteam.parkshark.api.divisions.dtos.DivisionDto.divisionDto;
import static com.switchfully.teamteam.parkshark.domain.divisions.Division.DivisionBuilder.division;

@Component
public class DivisionMapper implements Mapper<CreateDivisionDto, DivisionDto, Division> {

    private DirectorMapper directorMapper;

    @Autowired
    public DivisionMapper(DirectorMapper directorMapper) {
        this.directorMapper = directorMapper;
    }

    @Override
    public Division toDomain(CreateDivisionDto dto) {
        return division()
                .withName(dto.getName())
                .withOriginalName(dto.getOriginalName())
                .withDirector(directorMapper.toDomain(dto.getDirector()))
                .build();
    }

    @Override
    public DivisionDto toDto(Division division) {
        return divisionDto()
                .withName(division.getName())
                .withOriginalName(division.getOriginalName())
                .withDirector(directorMapper.toDto(division.getDirector()));
    }
}

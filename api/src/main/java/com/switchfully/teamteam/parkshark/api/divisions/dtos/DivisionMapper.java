package com.switchfully.teamteam.parkshark.api.divisions.dtos;

import com.switchfully.teamteam.parkshark.api.Mapper;
import com.switchfully.teamteam.parkshark.api.directors.dtos.DirectorMapper;
import com.switchfully.teamteam.parkshark.domain.divisions.Division;
import com.switchfully.teamteam.parkshark.service.divisions.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.switchfully.teamteam.parkshark.api.divisions.dtos.DivisionDto.divisionDto;
import static com.switchfully.teamteam.parkshark.domain.divisions.Division.DivisionBuilder.division;

@Component
public class DivisionMapper implements Mapper<CreateDivisionDto, DivisionDto, Division> {

    private DivisionService divisionService;
    private DirectorMapper directorMapper;

    @Autowired
    public DivisionMapper(DivisionService divisionService, DirectorMapper directorMapper) {
        this.divisionService = divisionService;
        this.directorMapper = directorMapper;
    }

    @Override
    public Division toDomain(CreateDivisionDto dto) {
        return division()
                .withName(dto.getName())
                .withOriginalName(dto.getOriginalName())
                .withDirector(directorMapper.toDomain(dto.getDirector()))
                .withParent(enrichWithParent(dto.getParentId()))
                .build();
    }

    @Override
    public DivisionDto toDto(Division division) {
        var dto = divisionDto()
                .withName(division.getName())
                .withOriginalName(division.getOriginalName())
                .withDirector(directorMapper.toDto(division.getDirector()));
        return enrichDtoWithParentId(dto, division);
    }

    private Division enrichWithParent(Long parentId) {
        if (parentId == null) {
            return null;
        }
        return getDivisionForId(parentId);
    }

    private DivisionDto enrichDtoWithParentId(DivisionDto dto, Division division) {
        return division.getParent() == null ?
                dto : dto.withParentId(division.getParent().getId());
    }

    private Division getDivisionForId(Long parentId) {
        return divisionService.findDivisionById(parentId);
    }

}

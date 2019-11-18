package com.switchfully.teamteam.parkshark.api.divisions.dtos;

import com.switchfully.teamteam.parkshark.api.directors.dtos.DirectorDto;

public class DivisionDto {

    private String name;
    private String originalName;
    private DirectorDto directorDto;

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public DirectorDto getDirector() {
        return directorDto;
    }

    public static DivisionDto divisionDto() {
        return new DivisionDto();
    }

    public DivisionDto withName(String name) {
        this.name = name;
        return this;
    }

    public DivisionDto withOriginalName(String originalName) {
        this.originalName = originalName;
        return this;
    }

    public DivisionDto withDirector(DirectorDto directorDto) {
        this.directorDto = directorDto;
        return this;
    }
}

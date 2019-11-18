package com.switchfully.teamteam.parkshark.api.divisions.dtos;

import com.switchfully.teamteam.parkshark.api.directors.dtos.CreateDirectorDto;

public class CreateDivisionDto {

    private String name;
    private String originalName;
    private CreateDirectorDto createDirectorDto;

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public CreateDirectorDto getDirector() {
        return createDirectorDto;
    }

    public static CreateDivisionDto createDivisionDto() {
        return new CreateDivisionDto();
    }

    public CreateDivisionDto withName(String name) {
        this.name = name;
        return this;
    }

    public CreateDivisionDto withOriginalName(String originalName) {
        this.originalName = originalName;
        return this;
    }

    public CreateDivisionDto withDirector(CreateDirectorDto createDirectorDto) {
        this.createDirectorDto = createDirectorDto;
        return this;
    }
}

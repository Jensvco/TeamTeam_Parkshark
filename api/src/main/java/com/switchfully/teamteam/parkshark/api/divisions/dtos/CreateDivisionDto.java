package com.switchfully.teamteam.parkshark.api.divisions.dtos;

import com.switchfully.teamteam.parkshark.api.directors.dtos.CreateDirectorDto;

public class CreateDivisionDto {

    private String name;
    private String originalName;
    private CreateDirectorDto director;
    private Integer parentId;

    public CreateDivisionDto() {
    }

    public static CreateDivisionDto createDivisionDto() {
        return new CreateDivisionDto();
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public CreateDirectorDto getDirector() {
        return director;
    }

    public Integer getParentId() {
        return parentId;
    }

    public CreateDivisionDto withName(String name) {
        this.name = name;
        return this;
    }

    public CreateDivisionDto withOriginalName(String originalName) {
        this.originalName = originalName;
        return this;
    }

    public CreateDivisionDto withDirector(CreateDirectorDto director) {
        this.director = director;
        return this;
    }

    public CreateDivisionDto withParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

}

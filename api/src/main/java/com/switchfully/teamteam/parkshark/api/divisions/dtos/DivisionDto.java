package com.switchfully.teamteam.parkshark.api.divisions.dtos;

import com.switchfully.teamteam.parkshark.api.directors.dtos.DirectorDto;

public class DivisionDto {

    private Long id;
    private String name;
    private String originalName;
    private DirectorDto director;
    private Long parentId;

    private DivisionDto() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public DirectorDto getDirector() {
        return director;
    }

    public Long getParentId() {
        return parentId;
    }

    public static DivisionDto divisionDto() {
        return new DivisionDto();
    }

    public DivisionDto withId(Long id) {
        this.id = id;
        return this;
    }

    public DivisionDto withName(String name) {
        this.name = name;
        return this;
    }

    public DivisionDto withOriginalName(String originalName) {
        this.originalName = originalName;
        return this;
    }

    public DivisionDto withDirector(DirectorDto director) {
        this.director = director;
        return this;
    }

    public DivisionDto withParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }
}

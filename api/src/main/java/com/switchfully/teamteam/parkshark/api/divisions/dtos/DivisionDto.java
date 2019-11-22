package com.switchfully.teamteam.parkshark.api.divisions.dtos;

import com.switchfully.teamteam.parkshark.api.directors.dtos.DirectorDto;

public class DivisionDto {

    private Integer id;
    private String name;
    private String originalName;
    private DirectorDto director;
    private Integer parentId;

    private DivisionDto() {
    }

    public static DivisionDto divisionDto() {
        return new DivisionDto();
    }

    public Integer getId() {
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

    public Integer getParentId() {
        return parentId;
    }

    public DivisionDto withId(Integer id) {
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

    public DivisionDto withParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }
}

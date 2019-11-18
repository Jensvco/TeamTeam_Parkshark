package com.switchfully.teamteam.parkshark.api.directors.dtos;

public class DirectorDto {
    private String firstName;
    private String lastName;

    public static DirectorDto directorDto() {
        return new DirectorDto();
    }

    public DirectorDto withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public DirectorDto withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}

package com.switchfully.teamteam.parkshark.api.directors.dtos;

public class DirectorDto {
    private String firstName;
    private String lastName;

    public static DirectorDto directorDto() {
        return new DirectorDto();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

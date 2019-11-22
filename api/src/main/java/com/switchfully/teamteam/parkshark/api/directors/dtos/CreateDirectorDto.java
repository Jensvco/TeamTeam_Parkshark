package com.switchfully.teamteam.parkshark.api.directors.dtos;

public class CreateDirectorDto {

    private String firstName;
    private String lastName;

    public static CreateDirectorDto createDirectorDto() {
        return new CreateDirectorDto();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public CreateDirectorDto withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CreateDirectorDto withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}

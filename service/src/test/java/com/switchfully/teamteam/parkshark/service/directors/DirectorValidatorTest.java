package com.switchfully.teamteam.parkshark.service.directors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.switchfully.teamteam.parkshark.domain.directors.Director.DirectorBuilder;
import static com.switchfully.teamteam.parkshark.domain.directors.Director.DirectorBuilder.director;
import static org.assertj.core.api.Assertions.assertThat;

class DirectorValidatorTest {

    private DirectorBuilder directorBuilder;
    private DirectorValidator validator;

    @BeforeEach
    void setUp() {
        validator = new DirectorValidator();

        directorBuilder = director()
                .withFirstName("Hello")
                .withLastName("World");
    }

    @Test
    void isValidForCreation_happyPath() {
        assertThat(validator.isValidForCreation(directorBuilder
                .build()))
                .isTrue();
    }

    @Test
    void isValidForCreation_givenNullFirstName_thenNotValidForCreation() {
        assertThat(validator.isValidForCreation(directorBuilder
                .withFirstName(null)
                .build()))
                .isFalse();
    }

    @Test
    void isValidForCreation_givenEmptyFirstName_thenNotValidForCreation() {
        assertThat(validator.isValidForCreation(directorBuilder
                .withFirstName("")
                .build()))
                .isFalse();
    }

    @Test
    void isValidForCreation_givenNullLastName_thenNotValidForCreation() {
        assertThat(validator.isValidForCreation(directorBuilder
                .withLastName(null)
                .build()))
                .isFalse();
    }

    @Test
    void isValidForCreation_givenEmptyLastName_thenNotValidForCreation() {
        assertThat(validator.isValidForCreation(directorBuilder
                .withLastName("")
                .build()))
                .isFalse();
    }

}
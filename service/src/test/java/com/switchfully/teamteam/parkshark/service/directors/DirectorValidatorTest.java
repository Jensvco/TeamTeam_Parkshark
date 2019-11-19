package com.switchfully.teamteam.parkshark.service.directors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.switchfully.teamteam.parkshark.domain.directors.Director.DirectorBuilder;
import static com.switchfully.teamteam.parkshark.domain.directors.Director.DirectorBuilder.director;
import static org.assertj.core.api.Assertions.assertThat;

class DirectorValidatorTest {

    private DirectorBuilder director;
    private DirectorValidator validator;

    @BeforeEach
    void setUp() {
        validator = new DirectorValidator();

        director = director()
                .withFirstName("Hello")
                .withLastName("World");
    }

    @Test
    void isValidForCreation_happyPath() {
        assertThat(validator.isValidForCreation(director
                .build()))
                .isTrue();
    }

    @Test
    void isValidForCreation_givenNullFirstName_thenNotValidForCreation() {
        assertThat(validator.isValidForCreation(director
                .withFirstName(null)
                .build()))
                .isFalse();
    }

    @Test
    void isValidForCreation_givenEmptyFirstName_thenNotValidForCreation() {
        assertThat(validator.isValidForCreation(director
                .withFirstName("")
                .build()))
                .isFalse();
    }

    @Test
    void isValidForCreation_givenNullLastName_thenNotValidForCreation() {
        assertThat(validator.isValidForCreation(director
                .withLastName(null)
                .build()))
                .isFalse();
    }

    @Test
    void isValidForCreation_givenEmptyLastName_thenNotValidForCreation() {
        assertThat(validator.isValidForCreation(director
                .withLastName("")
                .build()))
                .isFalse();
    }

}
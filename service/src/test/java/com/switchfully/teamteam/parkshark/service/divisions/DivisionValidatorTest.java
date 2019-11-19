package com.switchfully.teamteam.parkshark.service.divisions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.switchfully.teamteam.parkshark.domain.directors.Director.DirectorBuilder;
import static com.switchfully.teamteam.parkshark.domain.directors.Director.DirectorBuilder.director;
import static com.switchfully.teamteam.parkshark.domain.divisions.Division.DivisionBuilder;
import static com.switchfully.teamteam.parkshark.domain.divisions.Division.DivisionBuilder.division;
import static org.assertj.core.api.Assertions.assertThat;

class DivisionValidatorTest {

    private DirectorBuilder director;
    private DivisionBuilder division;
    private DivisionValidator validator;

    @BeforeEach
    void setUp() {
        validator = new DivisionValidator();

        director = director()
                .withFirstName("Hello")
                .withLastName("World");

        division = division()
                .withName("IT")
                .withOriginalName("Information Technology")
                .withDirector(director
                        .build());
    }

    @Test
    void isValidForCreation_happyPath() {
        assertThat(validator.isValidForCreation(division
                .build()))
                .isTrue();
    }

    @Test
    void isValidForCreation_givenNullName_thenNotValidForCreation() {
        assertThat(validator.isValidForCreation(division
                .withName(null)
                .build()))
                .isFalse();
    }

    @Test
    void isValidForCreation_givenEmptyName_thenNotValidForCreation() {
        assertThat(validator.isValidForCreation(division
                .withName("")
                .build()))
                .isFalse();
    }

    @Test
    void isValidForCreation_givenNullOriginalName_thenNotValidForCreation() {
        assertThat(validator.isValidForCreation(division
                .withOriginalName(null)
                .build()))
                .isFalse();
    }

    @Test
    void isValidForCreation_givenEmptyOriginalName_thenNotValidForCreation() {
        assertThat(validator.isValidForCreation(division
                .withOriginalName("")
                .build()))
                .isFalse();
    }

}
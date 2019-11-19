package com.switchfully.teamteam.parkshark.domain.divisions;

import org.junit.jupiter.api.Test;

import static com.switchfully.teamteam.parkshark.domain.directors.Director.DirectorBuilder.director;
import static com.switchfully.teamteam.parkshark.domain.divisions.Division.DivisionBuilder.division;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DivisionTest {

    @Test
    void createDivision() {
        // given & when
        var director = director()
                .withFirstName("Nick")
                .withLastName("Meert")
                .build();

        var division = division()
                .withDirector(director)
                .withName("IT")
                .withOriginalName("Technical guys")
                .build();

        // then
        assertThat(division.getDirector()).isEqualToComparingFieldByField(director);
        assertThat(division.getName()).isEqualTo("IT");
        assertThat(division.getOriginalName()).isEqualTo("Technical guys");
    }

}
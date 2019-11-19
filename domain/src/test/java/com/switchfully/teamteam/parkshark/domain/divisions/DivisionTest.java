package com.switchfully.teamteam.parkshark.domain.divisions;

import com.switchfully.teamteam.parkshark.domain.directors.Director;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.switchfully.teamteam.parkshark.domain.directors.Director.DirectorBuilder.director;
import static com.switchfully.teamteam.parkshark.domain.divisions.Division.DivisionBuilder.division;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DivisionTest {

    private Director director;

    @BeforeEach
    void setUp() {
        director = director()
                .withFirstName("Nick")
                .withLastName("Meert")
                .build();
    }

    @Test
    void createDivision_withoutParent() {
        // given & when
        var division = division()
                .withDirector(director)
                .withName("IT")
                .withOriginalName("Technical guys")
                .build();

        // then
        assertThat(division.getDirector()).isEqualToComparingFieldByField(director);
        assertThat(division.getName()).isEqualTo("IT");
        assertThat(division.getOriginalName()).isEqualTo("Technical guys");
        assertThat(division.getParent()).isNull();
    }

    @Test
    void createDivision_withParent() {
        // given & when
        var parent = division()
                .withDirector(director)
                .withName("Big Boss")
                .withOriginalName("Bossy Bossy")
                .build();

        var division = division()
                .withDirector(director)
                .withName("IT")
                .withOriginalName("Technical")
                .withParent(parent)
                .build();

        assertThat(parent.getParent()).isNull();
        assertThat(division.getDirector()).isEqualToComparingFieldByField(director);
        assertThat(division.getName()).isEqualTo("IT");
        assertThat(division.getOriginalName()).isEqualTo("Technical");
        assertThat(division.getParent()).usingRecursiveComparison()
                .isEqualTo(parent);
    }

}
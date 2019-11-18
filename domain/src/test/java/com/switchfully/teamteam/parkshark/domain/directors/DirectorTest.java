package com.switchfully.teamteam.parkshark.domain.directors;

import org.junit.jupiter.api.Test;

import static com.switchfully.teamteam.parkshark.domain.directors.Director.DirectorBuilder.director;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DirectorTest {

    @Test
    void createDirector() {
        // given & when
        var director = director()
                .withFirstName("Nick")
                .withLastName("Meert")
                .build();

        // then
        assertThat(director.getFirstName()).isEqualTo("Nick");
        assertThat(director.getLastName()).isEqualTo("Meert");
    }

}
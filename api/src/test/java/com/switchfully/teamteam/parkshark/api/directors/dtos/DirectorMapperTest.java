package com.switchfully.teamteam.parkshark.api.directors.dtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.switchfully.teamteam.parkshark.api.directors.dtos.CreateDirectorDto.createDirectorDto;
import static com.switchfully.teamteam.parkshark.api.directors.dtos.DirectorDto.directorDto;
import static com.switchfully.teamteam.parkshark.domain.directors.Director.DirectorBuilder.director;
import static org.assertj.core.api.Assertions.assertThat;

class DirectorMapperTest {

    private DirectorMapper directorMapper;

    @BeforeEach
    void setUp() {
        directorMapper = new DirectorMapper();
    }

    @Test
    void toDto() {
        // given
        var director = director()
                .withFirstName("Nick")
                .withLastName("Meert")
                .build();

        // when & then
        assertThat(directorMapper.toDto(director)).isEqualToComparingFieldByField(
                directorDto()
                        .withFirstName("Nick")
                        .withLastName("Meert"));
    }

    @Test
    void toDomain() {
        // given
        var dto = createDirectorDto()
                .withFirstName("Nick")
                .withLastName("Meert");

        // when & then
        assertThat(directorMapper.toDomain(dto)).isEqualToComparingFieldByField(
                director()
                        .withFirstName("Nick")
                        .withLastName("Meert")
                        .build());
    }

}
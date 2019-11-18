package com.switchfully.teamteam.parkshark.api.divisions.dtos;

import com.switchfully.teamteam.parkshark.api.directors.dtos.CreateDirectorDto;
import com.switchfully.teamteam.parkshark.api.directors.dtos.DirectorMapper;
import com.switchfully.teamteam.parkshark.domain.directors.Director;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.stereotype.Component;

import static com.switchfully.teamteam.parkshark.api.directors.dtos.CreateDirectorDto.createDirectorDto;
import static com.switchfully.teamteam.parkshark.api.directors.dtos.DirectorDto.directorDto;
import static com.switchfully.teamteam.parkshark.api.divisions.dtos.CreateDivisionDto.createDivisionDto;
import static com.switchfully.teamteam.parkshark.api.divisions.dtos.DivisionDto.divisionDto;
import static com.switchfully.teamteam.parkshark.domain.directors.Director.DirectorBuilder.director;
import static com.switchfully.teamteam.parkshark.domain.divisions.Division.DivisionBuilder.division;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@Component
class DivisionMapperTest {

    @Mock
    private DirectorMapper directorMapper;

    @InjectMocks
    private DivisionMapper divisionMapper;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void toDto() {
        // given
        when(directorMapper.toDto(any(Director.class))).thenReturn(
                directorDto()
                        .withFirstName("Nick")
                        .withLastName("Meert"));

        var division = division()
                .withDirector(director().build())
                .withName("IT")
                .withOriginalName("Technical guys")
                .build();

        // when & then
        assertThat(divisionMapper.toDto(division))
                .usingRecursiveComparison()
                .isEqualTo(
                        divisionDto()
                                .withName("IT")
                                .withOriginalName("Technical guys")
                                .withDirector(directorDto()
                                        .withFirstName("Nick")
                                        .withLastName("Meert")));
    }

    @Test
    void toDomain() {
        // given
        when(directorMapper.toDomain(any(CreateDirectorDto.class))).thenReturn(
                director()
                        .withFirstName("Nick")
                        .withLastName("Meert")
                        .build());

        var dto = createDivisionDto()
                .withDirector(createDirectorDto())
                .withName("IT")
                .withOriginalName("Technical guys");

        // when & then
        assertThat(divisionMapper.toDomain(dto))
                .usingRecursiveComparison()
                .isEqualTo(
                        division()
                                .withName("IT")
                                .withOriginalName("Technical guys")
                                .withDirector(director()
                                        .withFirstName("Nick")
                                        .withLastName("Meert")
                                        .build())
                                .build());
    }

}
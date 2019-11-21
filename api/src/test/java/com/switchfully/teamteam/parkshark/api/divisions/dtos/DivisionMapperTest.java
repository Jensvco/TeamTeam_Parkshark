package com.switchfully.teamteam.parkshark.api.divisions.dtos;

import com.switchfully.teamteam.parkshark.api.directors.dtos.CreateDirectorDto;
import com.switchfully.teamteam.parkshark.api.directors.dtos.DirectorMapper;
import com.switchfully.teamteam.parkshark.domain.directors.Director;
import com.switchfully.teamteam.parkshark.service.divisions.DivisionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static com.switchfully.teamteam.parkshark.api.directors.dtos.CreateDirectorDto.createDirectorDto;
import static com.switchfully.teamteam.parkshark.api.directors.dtos.DirectorDto.directorDto;
import static com.switchfully.teamteam.parkshark.api.divisions.dtos.CreateDivisionDto.createDivisionDto;
import static com.switchfully.teamteam.parkshark.api.divisions.dtos.DivisionDto.divisionDto;
import static com.switchfully.teamteam.parkshark.domain.directors.Director.DirectorBuilder.director;
import static com.switchfully.teamteam.parkshark.domain.divisions.Division.DivisionBuilder.division;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class DivisionMapperTest {

    @Mock
    private DirectorMapper directorMapper;

    @Mock
    private DivisionService divisionService;

    @InjectMocks
    private DivisionMapper divisionMapper;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void toDto_withoutParent() {
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
                .ignoringFields("id")
                .isEqualTo(
                        divisionDto()
                                .withName("IT")
                                .withOriginalName("Technical guys")
                                .withDirector(directorDto()
                                        .withFirstName("Nick")
                                        .withLastName("Meert")));
    }

    @Test
    void toDomain_withoutParent() {
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
                .ignoringFields("id")
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

    @Test
    void toDomain_withNonExistingParentId_thenShouldThrowException() {
        // given
        when(directorMapper.toDomain(any(CreateDirectorDto.class))).thenReturn(
                director()
                        .withFirstName("Nick")
                        .withLastName("Meert")
                        .build());
        when(divisionService.findDivisionById(10)).thenThrow(IllegalArgumentException.class);

        var dto = createDivisionDto()
                .withDirector(createDirectorDto())
                .withName("IT")
                .withOriginalName("IT")
                .withParentId(10);

        assertThatThrownBy(() -> divisionMapper.toDomain(dto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void toDomain_withExistingParentId_thenShouldCreateSubdivision() {
        // given
        when(directorMapper.toDomain(any(CreateDirectorDto.class))).thenReturn(
                director()
                        .withFirstName("Nick")
                        .withLastName("Meert")
                        .build());
        when(divisionService.findDivisionById(10)).thenReturn(division()
                .withName("Big Boss")
                .withOriginalName("Bossy")
                .build());

        var dto = createDivisionDto()
                .withDirector(createDirectorDto())
                .withName("IT")
                .withOriginalName("IT")
                .withParentId(10);

        assertThat(divisionMapper.toDomain(dto))
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(division()
                        .withName("IT")
                        .withOriginalName("IT")
                        .withDirector(director()
                                .withFirstName("Nick")
                                .withLastName("Meert")
                                .build())
                        .withParent(division()
                                .withName("Big Boss")
                                .withOriginalName("Bossy")
                                .build())
                        .build());
    }

    @Test
    void toDomain_withNullParentId_thenShouldCreateDivision() {
        // given
        when(directorMapper.toDomain(any(CreateDirectorDto.class))).thenReturn(
                director()
                        .withFirstName("Nick")
                        .withLastName("Meert")
                        .build());

        var dto = createDivisionDto()
                .withDirector(createDirectorDto())
                .withName("IT")
                .withOriginalName("IT");

        assertThat(divisionMapper.toDomain(dto))
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(division()
                        .withName("IT")
                        .withOriginalName("IT")
                        .withDirector(director()
                                .withFirstName("Nick")
                                .withLastName("Meert")
                                .build())
                        .build());
    }

}
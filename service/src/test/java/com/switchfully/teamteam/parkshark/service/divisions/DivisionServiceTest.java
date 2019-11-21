package com.switchfully.teamteam.parkshark.service.divisions;

import com.switchfully.teamteam.parkshark.domain.divisions.Division;
import com.switchfully.teamteam.parkshark.domain.divisions.DivisionRepository;
import com.switchfully.teamteam.parkshark.infrastructure.exception.NotCreatedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static com.switchfully.teamteam.parkshark.domain.directors.Director.DirectorBuilder.director;
import static com.switchfully.teamteam.parkshark.domain.divisions.Division.DivisionBuilder.division;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class DivisionServiceTest {

    @Mock
    private DivisionRepository divisionRepository;

    @Mock
    private DivisionValidator divisionValidator;

    @InjectMocks
    private DivisionService divisionService;

    private Division division;

    @BeforeEach
    void setUp() {
        initMocks(this);

        division = division()
                .withDirector(director()
                        .withFirstName("Nick")
                        .withLastName("Meert")
                        .build())
                .withName("IT")
                .withOriginalName("Technical guys")
                .build();
    }

    @Test
    void createDivision_whenDivisionValidForCreation() {
        when(divisionRepository.save(division)).thenReturn(division);
        when(divisionValidator.isValidForCreation(division)).thenReturn(true);

        assertThat(divisionService.createDivision(division))
                .usingRecursiveComparison()
                .isEqualTo(division);
    }

    @Test
    void createDivision_whenDivisionNOTValidForCreation_thenThrowException() {
        when(divisionRepository.save(division)).thenReturn(division);
        when(divisionValidator.isValidForCreation(division)).thenReturn(false);

        assertThatThrownBy(() -> divisionService.createDivision(division))
                .isInstanceOf(NotCreatedException.class);
    }

    @Test
    void getAllDivisions_hasRightSize() {
        when(divisionRepository.findAll()).thenReturn(List.of(division));

        assertThat(divisionService.getAllDivisions()).hasSize(1);
    }

    @Test
    void getAllDivisions_hasRightContent() {
        when(divisionRepository.findAll()).thenReturn(List.of(division));

        assertThat(divisionService.getAllDivisions().get(0))
                .usingRecursiveComparison()
                .isEqualTo(division()
                        .withDirector(director()
                                .withFirstName("Nick")
                                .withLastName("Meert")
                                .build())
                        .withName("IT")
                        .withOriginalName("Technical guys")
                        .build());
    }

}
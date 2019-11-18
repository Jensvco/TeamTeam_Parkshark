package com.switchfully.teamteam.parkshark.service.divisions;

import com.switchfully.teamteam.parkshark.domain.divisions.DivisionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static com.switchfully.teamteam.parkshark.domain.directors.Director.DirectorBuilder.director;
import static com.switchfully.teamteam.parkshark.domain.divisions.Division.DivisionBuilder.division;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class DivisionServiceTest {

    @Mock
    private DivisionRepository divisionRepository;

    @InjectMocks
    private DivisionService divisionService;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void createDivision() {
        // given
        var division = division()
                .withDirector(director()
                        .withFirstName("Nick")
                        .withLastName("Meert")
                        .build())
                .withName("IT")
                .withOriginalName("Technical guys")
                .build();

        when(divisionRepository.save(division)).thenReturn(division);

        // when & then
        assertThat(divisionService.createDivision(division))
                .usingRecursiveComparison()
                .isEqualTo(division);
    }

}
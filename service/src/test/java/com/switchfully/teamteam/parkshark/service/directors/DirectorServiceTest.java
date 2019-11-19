package com.switchfully.teamteam.parkshark.service.directors;

import com.switchfully.teamteam.parkshark.domain.directors.Director;
import com.switchfully.teamteam.parkshark.domain.directors.DirectorRepository;
import com.switchfully.teamteam.parkshark.service.EntityValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static com.switchfully.teamteam.parkshark.domain.directors.Director.DirectorBuilder.director;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class DirectorServiceTest {

    @Mock
    private DirectorRepository directorRepository;

    @Mock
    private DirectorValidator directorValidator;

    @InjectMocks
    private DirectorService directorService;

    private Director director;

    @BeforeEach
    void setUp() {
        initMocks(this);

        director = director()
                .withFirstName("Nick")
                .withLastName("Meert")
                .build();
    }

    @Test
    void createDirector_whenDirectorValidForCreation() {
        when(directorRepository.save(director)).thenReturn(director);
        when(directorValidator.isValidForCreation(director)).thenReturn(true);

        assertThat(directorService.createDirector(director)).isEqualToComparingFieldByField(director);
    }

    @Test
    void createDirector_whenDirectorNOTValidForCreation_thenThrowException() {
        when(directorRepository.save(director)).thenReturn(director);
        when(directorValidator.isValidForCreation(director)).thenReturn(false);

        assertThatThrownBy(() -> directorService.createDirector(director))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
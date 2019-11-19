package com.switchfully.teamteam.parkshark.service.directors;

import com.switchfully.teamteam.parkshark.domain.directors.Director;
import com.switchfully.teamteam.parkshark.domain.directors.DirectorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static com.switchfully.teamteam.parkshark.domain.directors.Director.DirectorBuilder.director;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class DirectorServiceTest {

    @Mock
    private DirectorRepository directorRepository;

    @InjectMocks
    private DirectorService directorService;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void createDirector() {
        Director director = director()
                .withFirstName("Nick")
                .withLastName("Meert")
                .build();
        when(directorRepository.save(director)).thenReturn(director);

        assertThat(directorService.createDirector(director)).isEqualToComparingFieldByField(director);
    }

}
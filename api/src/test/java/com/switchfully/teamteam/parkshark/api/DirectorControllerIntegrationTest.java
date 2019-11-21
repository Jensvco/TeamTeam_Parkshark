package com.switchfully.teamteam.parkshark.api;

import com.switchfully.teamteam.parkshark.ControllerIntegrationTest;
import com.switchfully.teamteam.parkshark.api.directors.DirectorController;
import com.switchfully.teamteam.parkshark.api.directors.dtos.CreateDirectorDto;
import com.switchfully.teamteam.parkshark.domain.directors.DirectorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static com.switchfully.teamteam.parkshark.api.directors.dtos.CreateDirectorDto.createDirectorDto;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

public class DirectorControllerIntegrationTest extends ControllerIntegrationTest {

    public static final String LOCALHOST = "http://localhost";

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public void clearDatabase() {
        /*directorRepository.deleteAll();*/
    }

    @Test
    void createDirector() {
        var createdDirector = new TestRestTemplate()
                .postForObject(format(LOCALHOST + ":%s/%s",
                        getPort(),
                        DirectorController.RESOURCE_NAME),
                        createADirector(),
                        CreateDirectorDto.class);

        assertThat(createdDirector).isEqualToComparingFieldByField(createADirector());
    }

    private CreateDirectorDto createADirector() {
        return createDirectorDto()
                .withFirstName("Hello")
                .withLastName("World");
    }

}

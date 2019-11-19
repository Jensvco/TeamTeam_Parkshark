package com.switchfully.teamteam.parkshark.api;

import com.switchfully.teamteam.parkshark.ControllerIntegrationTest;
import com.switchfully.teamteam.parkshark.api.divisions.DivisionController;
import com.switchfully.teamteam.parkshark.api.divisions.dtos.CreateDivisionDto;
import com.switchfully.teamteam.parkshark.api.divisions.dtos.DivisionDto;
import com.switchfully.teamteam.parkshark.domain.divisions.DivisionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static com.switchfully.teamteam.parkshark.api.directors.dtos.CreateDirectorDto.createDirectorDto;
import static com.switchfully.teamteam.parkshark.api.divisions.dtos.CreateDivisionDto.createDivisionDto;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

public class DivisionControllerIntegrationTest extends ControllerIntegrationTest {

    public static final String LOCALHOST = "http://localhost";

    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public void clearDatabase() {
        divisionRepository.deleteAll();
    }

    @BeforeEach
    void setUp() {
        clearDatabase();
    }

    @Test
    void createDivision() {
        var createdDivision = new TestRestTemplate()
                .postForObject(format(LOCALHOST + ":%s/%s",
                        getPort(),
                        DivisionController.RESOURCE_NAME),
                        createADivision(),
                        CreateDivisionDto.class);

        assertThat(createdDivision).usingRecursiveComparison()
                .isEqualTo(createADivision());
    }

    @Test
    void getAllDivisions_hasRightSize() {
        new TestRestTemplate()
                .postForObject(format(LOCALHOST + ":%s/%s",
                        getPort(),
                        DivisionController.RESOURCE_NAME),
                        createADivision(),
                        CreateDivisionDto.class);

        new TestRestTemplate()
                .postForObject(format(LOCALHOST + ":%s/%s",
                        getPort(),
                        DivisionController.RESOURCE_NAME),
                        createADivision(),
                        CreateDivisionDto.class);

        DivisionDto[] allDivisions = new TestRestTemplate()
                .getForObject(format(LOCALHOST + ":%s/%s", getPort(),
                        DivisionController.RESOURCE_NAME),
                        DivisionDto[].class);

        assertThat(allDivisions).hasSize(2);
    }

    @Test
    void getAllDivisions_hasRightContent() {
        var divisionInDb = new TestRestTemplate()
                .postForObject(format(LOCALHOST + ":%s/%s",
                        getPort(),
                        DivisionController.RESOURCE_NAME),
                        createADivision(),
                        CreateDivisionDto.class);

        DivisionDto[] allDivisions = new TestRestTemplate()
                .getForObject(format(LOCALHOST + ":%s/%s", getPort(),
                        DivisionController.RESOURCE_NAME),
                        DivisionDto[].class);

        assertThat(allDivisions).hasSize(1);
        assertThat(allDivisions[0])
                .usingRecursiveComparison()
                .isEqualTo(divisionInDb);
    }

    private CreateDivisionDto createADivision() {
        return createDivisionDto()
                .withName("Hello")
                .withOriginalName("World")
                .withDirector(createDirectorDto()
                        .withFirstName("Bye")
                        .withLastName("Moon"));
    }

}

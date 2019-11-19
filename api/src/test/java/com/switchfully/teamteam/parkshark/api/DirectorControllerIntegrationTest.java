package com.switchfully.teamteam.parkshark.api;

import com.switchfully.teamteam.parkshark.ControllerIntegrationTest;
import com.switchfully.teamteam.parkshark.domain.directors.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DirectorControllerIntegrationTest extends ControllerIntegrationTest {

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public void clearDatabase() {

    }

}

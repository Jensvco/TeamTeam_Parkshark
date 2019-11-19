package com.switchfully.teamteam.parkshark;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.transaction.TestTransaction;

import javax.transaction.Transactional;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {TestApplication.class},
        webEnvironment = RANDOM_PORT)
@Transactional
public abstract class ControllerIntegrationTest {

    @LocalServerPort
    private int port;

    public int getPort() {
        return port;
    }

    @BeforeEach
    public void clearAndFlushDatabase() {
        clearDatabase();
        TestTransaction.flagForCommit();
        TestTransaction.end();
        TestTransaction.start();
    }

    public abstract void clearDatabase();

}

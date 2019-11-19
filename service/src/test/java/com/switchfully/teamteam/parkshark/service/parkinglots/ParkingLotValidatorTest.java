package com.switchfully.teamteam.parkshark.service.parkinglots;

import com.switchfully.teamteam.parkshark.domain.models.ParkingLot;
import com.switchfully.teamteam.parkshark.service.parking_lots.ParkingLotValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParkingLotValidatorTest {
    private ParkingLot.ParkingLotBuilder parkinglot;
    private ParkingLotValidator validator;

    @BeforeEach
    void setUp() {
        validator = new ParkingLotValidator();

        parkinglot = new ParkingLot.ParkingLotBuilder()
                .withCapacity(500)
                .withName("Blok A")
                .withPricePerHour(10);
    }

    @Test
    void isValidForCreation_happyPath() {
        assertThat(validator.isValidForCreation(parkinglot
                .build()))
                .isTrue();
    }

    @Test
    void isValidForCreation_givenNullName_thenNotValidForCreation() {
        assertThat(validator.isValidForCreation(parkinglot
                .withName(null)
                .build()))
                .isFalse();
    }

    @Test
    void isValidForCreation_givenEmptyFirstName_thenNotValidForCreation() {
        assertThat(validator.isValidForCreation(parkinglot
                .withName("")
                .build()))
                .isFalse();
    }
}

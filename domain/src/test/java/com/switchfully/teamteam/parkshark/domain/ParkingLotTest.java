package com.switchfully.teamteam.parkshark.domain;

import com.switchfully.teamteam.parkshark.domain.models.ParkingLot;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ParkingLotTest {
    @Test
    void parkingLotBuilderTest() {
        ParkingLotCategory parkingLotCategory = new ParkingLotCategory("Underground");
        ParkingLot parkingLot = new ParkingLot.Builder()
                .withName("Blok A")
                .withParkingLotCategory(parkingLotCategory)
                .withCapacity(500)
                .withPricePerHour(10)
                .build();

        Assertions.assertThat(parkingLot.getName().equals("Blok A"));
        Assertions.assertThat(parkingLot.getParkingLotCategory().equals(parkingLotCategory));
        Assertions.assertThat(parkingLot.getCapacity() == 500);
    }
}
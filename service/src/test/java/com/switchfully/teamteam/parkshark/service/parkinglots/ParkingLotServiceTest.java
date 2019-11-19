package com.switchfully.teamteam.parkshark.service.parkinglots;

import com.switchfully.teamteam.parkshark.domain.models.ParkingLot;
import com.switchfully.teamteam.parkshark.domain.repositories.ParkingLotRepository;
import com.switchfully.teamteam.parkshark.service.parking_lots.ParkingLotService;
import com.switchfully.teamteam.parkshark.service.parking_lots.ParkingLotValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ParkingLotServiceTest {
    @Mock
    private ParkingLotRepository parkingLotRepository;

    @Mock
    private ParkingLotValidator parkingLotValidator;

    @InjectMocks
    private ParkingLotService parkingLotService;

    public ParkingLot parkingLot;

    public ParkingLotServiceTest() {
    }

    @BeforeEach
    void setUp() {
        initMocks(this);

        parkingLot = new ParkingLot.ParkingLotBuilder()
                .withCapacity(500)
                .withName("Blok A")
                .withPricePerHour(10)
                .build();
    }

    @Test
    void createParkingLot_whenParkingLotValidForCreation() {
        when(parkingLotRepository.save(parkingLot)).thenReturn(parkingLot);
        when(parkingLotValidator.isValidForCreation(parkingLot)).thenReturn(true);

        assertThat(parkingLotService.createParkingLot(parkingLot)).isEqualToComparingFieldByField(parkingLot);
    }
}

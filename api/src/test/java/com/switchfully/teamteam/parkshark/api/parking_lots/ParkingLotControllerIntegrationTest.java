package com.switchfully.teamteam.parkshark.api.parking_lots;

import com.switchfully.teamteam.parkshark.ControllerIntegrationTest;
import com.switchfully.teamteam.parkshark.api.addresses.dto.CreateAddressDto;
import com.switchfully.teamteam.parkshark.api.contact_persons.dto.CreateContactPersonDto;
import com.switchfully.teamteam.parkshark.api.phone_numbers.CreatePhoneNumberDto;
import com.switchfully.teamteam.parkshark.domain.PhoneNumber;
import com.switchfully.teamteam.parkshark.domain.divisions.Division;
import com.switchfully.teamteam.parkshark.domain.divisions.DivisionRepository;
import com.switchfully.teamteam.parkshark.domain.repositories.ParkingLotRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

import static com.switchfully.teamteam.parkshark.domain.ParkingLotCategory.UNDERGROUND;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

public class ParkingLotControllerIntegrationTest extends ControllerIntegrationTest {
    public static final String LOCALHOST = "http://localhost";

    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Autowired
    private DivisionRepository divisionRepository;

    private Division division;


    @Override
    public void clearDatabase() {
        parkingLotRepository.deleteAll();
    }

    @BeforeEach
    void setup() {
        division = divisionRepository.findByName("division_name");
    }

    @Test
    @Sql("/create_test_division.sql")
    void createParkingLot() {
        var newParkingLot = new TestRestTemplate()
                .postForObject(format(LOCALHOST + ":%s/%s",
                        getPort(),
                        ParkingLotController.PARKING_LOT_RESOURCE_NAME),
                        createNewParkingLot(),
                        ParkingLotDto.class);

        assertThat(newParkingLot.getCapacity()).isEqualTo(createNewParkingLot().getCapacity());
        assertThat(newParkingLot.getName()).isEqualTo(createNewParkingLot().getName());
        assertThat(newParkingLot.getPricePerHour()).isEqualTo(createNewParkingLot().getPricePerHour());
        assertThat(newParkingLot.getDivisionDto().getId()).isEqualTo(division.getId());
    }


    @Test
    void getAllParkingLots() {
        new TestRestTemplate()
                .postForObject(format(LOCALHOST + ":%s/parkinglots",
                        getPort()),
                        createNewParkingLot(),
                        CreateParkingLotDto.class);

        new TestRestTemplate()
                .postForObject(format(LOCALHOST + ":%s/parkinglots",
                        getPort()),
                        createNewParkingLot(),
                        CreateParkingLotDto.class);

        ParkingLotDto[] allParkingLots = new TestRestTemplate()
                .getForObject(format(LOCALHOST + ":%s/parkinglots",
                        getPort()),
                        ParkingLotDto[].class);

        assertThat(allParkingLots).hasSize(2);
    }

    private CreateParkingLotDto createNewParkingLot() {
        List<CreatePhoneNumberDto> phoneNumberList = new ArrayList<>();
        CreatePhoneNumberDto phoneNumber = new CreatePhoneNumberDto("0474531267", PhoneNumber.PhoneNumberType.MOBILE_PHONE);
        phoneNumberList.add(phoneNumber);
        return new CreateParkingLotDto.Builder()
                .withDivisionId(division.getId())
                .withName("ParkingLot1")
                .withCapacity(500)
                .withPricePerHour(10)
                .withParkingLotCategory(UNDERGROUND)
                .withAddress(new CreateAddressDto("Street", "Number", "9000", "Gent"))
                .withContactPerson(new CreateContactPersonDto("Jens", phoneNumberList, "Jensvco@gmail.com", new CreateAddressDto("Street", "Number", "9000", "Gent")))
                .build();
    }

}

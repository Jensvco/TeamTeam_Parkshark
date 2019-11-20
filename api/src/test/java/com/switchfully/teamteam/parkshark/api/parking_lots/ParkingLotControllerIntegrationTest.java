package com.switchfully.teamteam.parkshark.api.parking_lots;

import com.switchfully.teamteam.parkshark.ControllerIntegrationTest;
import com.switchfully.teamteam.parkshark.api.addresses.dto.CreateAddressDto;
import com.switchfully.teamteam.parkshark.api.contact_persons.dto.CreateContactPersonDto;
import com.switchfully.teamteam.parkshark.api.phone_numbers.CreatePhoneNumberDto;
import com.switchfully.teamteam.parkshark.domain.PhoneNumber;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.switchfully.teamteam.parkshark.domain.ParkingLotCategory.UNDERGROUND;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

public class ParkingLotControllerIntegrationTest extends ControllerIntegrationTest {
    public static final String LOCALHOST = "http://localhost";

    @Override
    public void clearDatabase() {

    }

    @Test
    void createParkingLot() {
        var createdParkingLot = new TestRestTemplate()
                .postForObject(format(LOCALHOST + ":%s/parkinglots",
                        getPort()),
                        createAParkingLot(),
                        CreateParkingLotDto.class);

        assertThat(createdParkingLot)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(createAParkingLot());
    }

    private CreateParkingLotDto createAParkingLot() {
        List<CreatePhoneNumberDto> phoneNumberList = new ArrayList<>();
        CreatePhoneNumberDto phoneNumber = new CreatePhoneNumberDto("0474531267", PhoneNumber.PhoneNumberType.MOBILE_PHONE);
        phoneNumberList.add(phoneNumber);
        return new CreateParkingLotDto.Builder()
                .withName("ParkingLot1")
                .withCapacity(500)
                .withPricePerHour(10)
                .withParkingLotCategory(UNDERGROUND)
                .withAddress(new CreateAddressDto("Street", "Number", "9000", "Gent"))
                .withContactPerson(new CreateContactPersonDto("Jens", phoneNumberList, "Jensvco@gmail.com", new CreateAddressDto("Street", "Number", "9000", "Gent")))
                .build();
    }



}
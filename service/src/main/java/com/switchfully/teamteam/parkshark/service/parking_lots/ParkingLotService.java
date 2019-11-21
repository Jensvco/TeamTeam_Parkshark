package com.switchfully.teamteam.parkshark.service.parking_lots;

import com.switchfully.teamteam.parkshark.domain.PhoneNumber;
import com.switchfully.teamteam.parkshark.domain.models.ParkingLot;
import com.switchfully.teamteam.parkshark.domain.repositories.ContactPersonRepository;
import com.switchfully.teamteam.parkshark.domain.repositories.ParkingLotRepository;
import com.switchfully.teamteam.parkshark.infrastructure.apiExceptions.ApiRequestException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ParkingLotService {

    private final ParkingLotRepository parkingLotRepository;
    private final ContactPersonRepository contactPersonRepository;
    private final ParkingLotValidator parkingLotValidator;

    public ParkingLotService(ParkingLotRepository parkingLotRepository, ContactPersonRepository contactPersonRepository, ParkingLotValidator parkingLotValidator) {
        this.parkingLotRepository = parkingLotRepository;
        this.contactPersonRepository = contactPersonRepository;
        this.parkingLotValidator = parkingLotValidator;
    }

    public ParkingLot createParkingLot(ParkingLot parkingLotToCreate) {
        if (!parkingLotValidator.isValidForCreation(parkingLotToCreate)) {
            throw new ApiRequestException("wrong JSON format");
        }
        return parkingLotRepository.save(parkingLotToCreate);
    }

    public List<ParkingLot> findAllParkingLots() {
        return parkingLotRepository.findAll();
    }

    public ParkingLot findParkingLotById(int id) {
       return parkingLotRepository.findById(id).orElse(null);
    }

    public void addPhoneNumbers(int contactPersonId, List<PhoneNumber> phoneNumberList) {
        contactPersonRepository.findById(contactPersonId).ifPresent(c -> c.getPhoneNumbers().addAll(phoneNumberList));
    }

}


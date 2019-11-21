package com.switchfully.teamteam.parkshark.service.divisions;

import com.switchfully.teamteam.parkshark.domain.divisions.Division;
import com.switchfully.teamteam.parkshark.domain.divisions.DivisionRepository;
import com.switchfully.teamteam.parkshark.infrastructure.apiExceptions.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.String.format;

@Service
@Transactional
public class DivisionService {

    private final DivisionRepository divisionRepository;
    private final DivisionValidator divisionValidator;

    @Autowired
    public DivisionService(DivisionRepository divisionRepository,
                           DivisionValidator divisionValidator) {
        this.divisionRepository = divisionRepository;
        this.divisionValidator = divisionValidator;
    }

    public Division createDivision(Division divisionToCreate) {
        if (!divisionValidator.isValidForCreation(divisionToCreate)) {
            throw  new ApiRequestException("Wrong JSON format");
        }
        return divisionRepository.save(divisionToCreate);
    }

    public List<Division> getAllDivisions() {
        return divisionRepository.findAll();
    }

    public Division findDivisionById(int id) {
        return divisionRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException(format("Id %s cannot be found", id)));
    }

}

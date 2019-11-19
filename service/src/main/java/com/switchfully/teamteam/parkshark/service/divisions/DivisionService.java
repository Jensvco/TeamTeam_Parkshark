package com.switchfully.teamteam.parkshark.service.divisions;

import com.switchfully.teamteam.parkshark.domain.divisions.Division;
import com.switchfully.teamteam.parkshark.domain.divisions.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
            throw new IllegalArgumentException();
        }
        return divisionRepository.save(divisionToCreate);
    }

    public List<Division> getAllDivisions() {
        return divisionRepository.findAll();
    }

    public Division findDivisionById(long id) {
        return divisionRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

}

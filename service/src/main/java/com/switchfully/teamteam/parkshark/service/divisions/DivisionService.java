package com.switchfully.teamteam.parkshark.service.divisions;

import com.switchfully.teamteam.parkshark.domain.divisions.Division;
import com.switchfully.teamteam.parkshark.domain.divisions.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService {

    private final DivisionRepository divisionRepository;

    @Autowired
    public DivisionService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public Division createDivision(Division divisionToCreate){
        return divisionRepository.save(divisionToCreate);
    }

    public List<Division> getAllDivisions() {
        return divisionRepository.findAll();
    }

}

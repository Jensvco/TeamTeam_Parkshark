package com.switchfully.teamteam.parkshark.service.divisions;

import com.switchfully.teamteam.parkshark.domain.divisions.Division;
import com.switchfully.teamteam.parkshark.service.EntityValidator;
import org.springframework.stereotype.Component;

@Component
public class DivisionValidator extends EntityValidator<Division> {


    @Override
    protected boolean isAFieldEmptyOrNull(Division division) {
        return isNull(division)
                || isEmptyOrNull(division.getName())
                || isEmptyOrNull(division.getOriginalName())
                || isNull(division.getDirector())
                || isEmptyOrNull(division.getDirector().getFirstName())
                || isEmptyOrNull(division.getDirector().getLastName());
    }

}

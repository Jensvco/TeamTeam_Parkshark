package com.switchfully.teamteam.parkshark.service.directors;

import com.switchfully.teamteam.parkshark.domain.directors.Director;
import com.switchfully.teamteam.parkshark.service.EntityValidator;
import org.springframework.stereotype.Component;

@Component
public class DirectorValidator extends EntityValidator<Director> {

    @Override
    protected boolean isAFieldEmptyOrNull(Director director) {
        return isNull(director)
                || isEmptyOrNull(director.getFirstName())
                || isEmptyOrNull(director.getLastName());
    }

}

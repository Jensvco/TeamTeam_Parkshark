package com.switchfully.teamteam.parkshark.service.directors;

import com.switchfully.teamteam.parkshark.domain.directors.Director;
import com.switchfully.teamteam.parkshark.domain.directors.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DirectorService {

    private final DirectorRepository directorRepository;
    private final DirectorValidator directorValidator;

    @Autowired
    public DirectorService(DirectorRepository directorRepository,
                           DirectorValidator directorValidator) {
        this.directorRepository = directorRepository;
        this.directorValidator = directorValidator;
    }

    public Director createDirector(Director directorToCreate) {
        if (!directorValidator.isValidForCreation(directorToCreate)) {
            throw new IllegalArgumentException();
        }
        return directorRepository.save(directorToCreate);
    }

}

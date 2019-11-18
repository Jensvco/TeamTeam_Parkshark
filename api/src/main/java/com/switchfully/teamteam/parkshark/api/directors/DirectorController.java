package com.switchfully.teamteam.parkshark.api.directors;


import com.switchfully.teamteam.parkshark.api.directors.dtos.CreateDirectorDto;
import com.switchfully.teamteam.parkshark.api.directors.dtos.DirectorDto;
import com.switchfully.teamteam.parkshark.api.directors.dtos.DirectorMapper;
import com.switchfully.teamteam.parkshark.domain.directors.Director;
import com.switchfully.teamteam.parkshark.service.directors.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "directors")
@RestController
public class DirectorController {

    private final DirectorService directorService;
    private final DirectorMapper directorMapper;

    @Autowired
    public DirectorController(DirectorService directorService, DirectorMapper directorMapper) {
        this.directorService = directorService;
        this.directorMapper = directorMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public DirectorDto createDirector(@RequestBody CreateDirectorDto directorDto){
        Director newDirector = directorService.createADirector(directorMapper.toDomain(directorDto));
        return directorMapper.toDto(newDirector);
    }
}

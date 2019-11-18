package com.switchfully.teamteam.parkshark.api.directors;


import com.switchfully.teamteam.parkshark.api.directors.dtos.CreateDirectorDto;
import com.switchfully.teamteam.parkshark.api.directors.dtos.DirectorDto;
import com.switchfully.teamteam.parkshark.api.directors.dtos.DirectorMapper;
import com.switchfully.teamteam.parkshark.domain.directors.Director;
import com.switchfully.teamteam.parkshark.service.directors.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "/directors")
@RestController
public class DirectorController {

    private final DirectorService directorService;
    private final DirectorMapper directorMapper;

    @Autowired
    public DirectorController(DirectorService directorService, DirectorMapper directorMapper) {
        this.directorService = directorService;
        this.directorMapper = directorMapper;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public DirectorDto createDirector(@RequestBody CreateDirectorDto dto){
        Director newDirector = directorService.createADirector(directorMapper.toDomain(dto));
        return directorMapper.toDto(newDirector);
    }
}

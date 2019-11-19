package com.switchfully.teamteam.parkshark.api.divisions;

import com.switchfully.teamteam.parkshark.api.divisions.dtos.CreateDivisionDto;
import com.switchfully.teamteam.parkshark.api.divisions.dtos.DivisionDto;
import com.switchfully.teamteam.parkshark.api.divisions.dtos.DivisionMapper;
import com.switchfully.teamteam.parkshark.service.divisions.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.switchfully.teamteam.parkshark.api.divisions.DivisionController.RESOURCE_NAME;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/" + RESOURCE_NAME)
public class DivisionController {

    public static final String RESOURCE_NAME = "divisions";

    private DivisionService divisionService;
    private DivisionMapper divisionMapper;

    @Autowired
    public DivisionController(DivisionService divisionService, DivisionMapper divisionMapper) {
        this.divisionService = divisionService;
        this.divisionMapper = divisionMapper;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public DivisionDto createDivision(@RequestBody CreateDivisionDto dto) {
        var divisionToCreate = divisionMapper.toDomain(dto);
        return divisionMapper.toDto(divisionService.createDivision(divisionToCreate));
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public List<DivisionDto> getAllDivisions() {
        return divisionService.getAllDivisions().stream()
                .map(division -> divisionMapper.toDto(division))
                .collect(toList());
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public DivisionDto getDivision(@PathVariable long id) {
        return divisionMapper.toDto(divisionService.findDivisionById(id));
    }

}

package com.switchfully.teamteam.parkshark.api.directors.dtos;

import com.switchfully.teamteam.parkshark.api.Mapper;
import com.switchfully.teamteam.parkshark.domain.directors.Director;
import org.springframework.stereotype.Component;

import static com.switchfully.teamteam.parkshark.api.directors.dtos.DirectorDto.directorDto;
import static com.switchfully.teamteam.parkshark.domain.directors.Director.DirectorBuilder.director;
@Component
public class DirectorMapper implements Mapper<CreateDirectorDto, DirectorDto, Director> {

    @Override
    public Director toDomain(CreateDirectorDto dto) {
        return director()
                .withFirstName(dto.getFirstName())
                .withLastName(dto.getLastName())
                .build();
    }

    @Override
    public DirectorDto toDto(Director director) {
        return directorDto()
                .withFirstName(director.getFirstName())
                .withLastName(director.getLastName());
    }

}

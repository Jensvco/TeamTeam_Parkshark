package com.switchfully.teamteam.parkshark.domain.repositories;

import com.switchfully.teamteam.parkshark.domain.ParkingSpot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingSpotRepository extends CrudRepository<ParkingSpot, String> {

    @Override
    List<ParkingSpot> findAll();
}

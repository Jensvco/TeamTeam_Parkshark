package com.switchfully.teamteam.parkshark.domain.repositories;

import com.switchfully.teamteam.parkshark.domain.models.ParkingLot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepository extends CrudRepository<ParkingLot, Integer> {

}

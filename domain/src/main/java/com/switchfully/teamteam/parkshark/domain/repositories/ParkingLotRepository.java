package com.switchfully.teamteam.parkshark.domain.repositories;

import com.switchfully.teamteam.parkshark.domain.models.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Integer> {
}

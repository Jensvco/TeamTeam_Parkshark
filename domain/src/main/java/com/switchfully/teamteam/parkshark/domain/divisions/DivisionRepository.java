package com.switchfully.teamteam.parkshark.domain.divisions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Integer> {

    Division findByName(String name);
}

package com.switchfully.teamteam.parkshark.domain.repositories;

import com.switchfully.teamteam.parkshark.domain.models.ContactPerson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactPersonRepository extends CrudRepository<ContactPerson, Integer> {

}

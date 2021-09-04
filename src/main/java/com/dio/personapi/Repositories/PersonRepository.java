package com.dio.personapi.Repositories;

import com.dio.personapi.Entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

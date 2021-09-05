package com.dio.personapi.Repositories;

import com.dio.personapi.Entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}

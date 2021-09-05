package com.dio.personapi.DTO.Mapper;

import com.dio.personapi.DTO.Request.PersonDTO;
import com.dio.personapi.DTO.Request.PhoneDTO;
import com.dio.personapi.Entities.Person;
import com.dio.personapi.Entities.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PhoneMapper {

    Phone toModel(PhoneDTO dto);

    PhoneDTO toDTO(Phone dto);
}

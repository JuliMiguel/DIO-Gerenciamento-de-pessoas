package com.dio.personapi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PhoneNotFoundException extends Exception {
    public PhoneNotFoundException(Long id){

        super(String.format("Telefone com ID %s não encontrada!", id));

    }
}

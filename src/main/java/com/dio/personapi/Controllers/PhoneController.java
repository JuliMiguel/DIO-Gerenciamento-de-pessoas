package com.dio.personapi.Controllers;

import com.dio.personapi.DTO.Request.PhoneDTO;
import com.dio.personapi.DTO.Response.MessageResponseDTO;
import com.dio.personapi.Exception.PhoneNotFoundException;
import com.dio.personapi.Services.PhoneService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PhoneController {

    private final PhoneService phoneService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid PhoneDTO phoneDTO) {
        return phoneService.create(phoneDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PhoneDTO findById(@PathVariable Long id) throws PhoneNotFoundException {
        return phoneService.findById(id);
    }

    @GetMapping
    public List<PhoneDTO> listAll() {
        return phoneService.listAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid PhoneDTO phoneDTO) throws PhoneNotFoundException {
        return phoneService.update(id, phoneDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws PhoneNotFoundException {
        phoneService.delete(id);
    }
}

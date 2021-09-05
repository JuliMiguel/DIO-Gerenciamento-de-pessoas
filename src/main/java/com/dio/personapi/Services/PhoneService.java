package com.dio.personapi.Services;

import com.dio.personapi.DTO.Mapper.PhoneMapper;
import com.dio.personapi.DTO.Request.PhoneDTO;
import com.dio.personapi.DTO.Response.MessageResponseDTO;
import com.dio.personapi.Entities.Phone;
import com.dio.personapi.Exception.PhoneNotFoundException;
import com.dio.personapi.Repositories.PhoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor =@__(@Autowired) )
public class PhoneService {

    private final PhoneRepository phoneRepository;

    private final PhoneMapper phoneMapper;

    public MessageResponseDTO create(PhoneDTO phoneDTO) {
        Phone phone = phoneMapper.toModel(phoneDTO);
        Phone savedPhone = phoneRepository. save(phone);

        MessageResponseDTO messageResponse = createMessageResponse("Telefone criado com sucesso com ID ", savedPhone.getId());

        return messageResponse;
    }

    public PhoneDTO findById(Long id) throws PhoneNotFoundException {
        Phone phone = phoneRepository.findById(id)
                .orElseThrow(() -> new PhoneNotFoundException(id));

        return phoneMapper.toDTO(phone);
    }

    public List<PhoneDTO> listAll() {
        List<Phone> phones = phoneRepository.findAll();
        return phones.stream()
                .map(phoneMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO update(Long id, PhoneDTO phoneDTO) throws PhoneNotFoundException {
        phoneRepository.findById(id)
                .orElseThrow(() -> new PhoneNotFoundException(id));

        Phone updatedPhone = phoneMapper.toModel(phoneDTO);
        Phone savedPhone = phoneRepository.save(updatedPhone);

        MessageResponseDTO messageResponse = createMessageResponse("Telefone atualizado com ID ", savedPhone.getId());

        return messageResponse;
    }

    public void delete(Long id) throws PhoneNotFoundException {
        phoneRepository.findById(id)
                .orElseThrow(() -> new PhoneNotFoundException(id));

        phoneRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(String s, Long id2) {
        return MessageResponseDTO.builder()
                .message(s + id2)
                .build();
    }
}

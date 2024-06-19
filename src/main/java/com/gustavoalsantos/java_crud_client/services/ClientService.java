package com.gustavoalsantos.java_crud_client.services;

import com.gustavoalsantos.java_crud_client.dto.ClientDTO;
import com.gustavoalsantos.java_crud_client.entities.Client;
import com.gustavoalsantos.java_crud_client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client client = repository.findById(id).get();
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){
        Page<Client> result = repository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }

    public ClientDTO insert(ClientDTO dto){
        Client entity = new Client();
        copyDTOClient(entity, dto);
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }

    public void copyDTOClient(Client client, ClientDTO dto){

        client.setName(dto.getName());
        client.setCpf(dto.getCpf());
        client.setIncome(dto.getIncome());
        client.setBirthDate(dto.getBirthDate());
        client.setChildren(dto.getChildren());
    }
}

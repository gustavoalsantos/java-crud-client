package com.gustavoalsantos.java_crud_client.controllers;

import com.gustavoalsantos.java_crud_client.dto.ClientDTO;
import com.gustavoalsantos.java_crud_client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping(value = "/{id}")
    public ClientDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    public Page<ClientDTO> findAll(Pageable pageable){
        return service.findAll(pageable);
    }

}
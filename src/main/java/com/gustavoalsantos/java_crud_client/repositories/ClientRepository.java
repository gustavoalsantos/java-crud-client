package com.gustavoalsantos.java_crud_client.repositories;

import com.gustavoalsantos.java_crud_client.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

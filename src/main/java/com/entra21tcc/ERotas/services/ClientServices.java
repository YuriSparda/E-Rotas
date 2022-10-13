package com.entra21tcc.ERotas.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21tcc.ERotas.entities.Client;
import com.entra21tcc.ERotas.repositories.ClientRepository;

@Service
public class ClientServices {
    @Autowired
    private ClientRepository cRepository;

    public List<Client> findAll() {
        return cRepository.findAll();
    }

    public Client findById(Integer id) {
        Optional<Client> client = cRepository.findById(id);
        return client.orElseThrow(
                () -> new ObjectNotFoundException(
                        "Objeto não encontrado! Id: " + id + ", Tipo: " + Client.class.getName(), null));
    }
}

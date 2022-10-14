package com.entra21tcc.ERotas.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.entra21tcc.ERotas.entities.Client;
import com.entra21tcc.ERotas.repositories.ClientRepository;
import com.entra21tcc.ERotas.services.ClientServices;

@RestController
@RequestMapping(value = "/Clients")
public class ClientController {

    @Autowired
    private ClientRepository cRepository;

    @Autowired
    private ClientServices cServices;

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        List<Client> clientList = cServices.findAll();
        return ResponseEntity.ok().body(clientList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> findById(@PathVariable Integer id) {
        Client clientList = cServices.findById(id);
        return ResponseEntity.ok().body(clientList);
    }

    @PostMapping(value = "/newUser")
    public ResponseEntity<Client> insClient(@Valid @RequestBody Client pClient) {
        pClient.setIdClient(null);
        cRepository.save(pClient);
        URI yURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pClient.getIdClient())
                .toUri();
        return ResponseEntity.created(yURI).body(pClient);
    }

    @PutMapping(value = "/editUser")
    public ResponseEntity<Client> updClient(@Valid @PathVariable Integer id, @RequestBody Client pClient) {
        Client atualClient = cRepository.findById(id)
                .orElseThrow(
                        () -> new ObjectNotFoundException(id, " user is not fond"));
        atualClient.setName(pClient.getName());
        atualClient.setNumber(pClient.getNumber());
        atualClient.setMail(pClient.getMail());
        atualClient.setCpf(pClient.getCpf());
        cRepository.save(atualClient);
        return ResponseEntity.ok().body(atualClient);

    }

}

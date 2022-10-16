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

import com.entra21tcc.ERotas.entities.Deliveryman;
import com.entra21tcc.ERotas.repositories.DeliverymanRepository;
import com.entra21tcc.ERotas.services.DeliverymanServices;

@RestController
@RequestMapping(value = "/Clients")
public class DeliverymanController {

    @Autowired
    private DeliverymanRepository dRepository;

    @Autowired
    private DeliverymanServices dServices;

    @GetMapping
    public ResponseEntity<List<Deliveryman>> findAll() {
        List<Deliveryman> delivereList = dServices.findAll();
        return ResponseEntity.ok().body(delivereList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Deliveryman> findById(@PathVariable Integer id) {
        Deliveryman clientList = dServices.findById(id);
        return ResponseEntity.ok().body(clientList);
    }

    @PostMapping(value = "/newUser")
    public ResponseEntity<Deliveryman> insClient(@Valid @RequestBody Deliveryman pDeliveryman) {
        pDeliveryman.setIdMotorista(null);
        dRepository.save(pDeliveryman);
        URI yURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(pDeliveryman.getIdMotorista())
                .toUri();
        return ResponseEntity.created(yURI).body(pDeliveryman);
    }

    @PutMapping(value = "/editUser")
    public ResponseEntity<Deliveryman> updClient(@Valid @PathVariable Integer id,
            @RequestBody Deliveryman pDeliveryman) {
        Deliveryman atualDeliveryman = dRepository.findById(id)
                .orElseThrow(
                        () -> new ObjectNotFoundException(id, " user is not fond"));
        atualDeliveryman.setNmMotorista(pDeliveryman.getNmMotorista());
        atualDeliveryman.setNumero(pDeliveryman.getNumero());
        atualDeliveryman.setPlacaVeiculo(pDeliveryman.getPlacaVeiculo());
        dRepository.save(atualDeliveryman);
        return ResponseEntity.ok().body(atualDeliveryman);

    }

    @GetMapping(value = "/Deliver_{id}_veicle")
    public ResponseEntity<String> addressFind(@PathVariable Integer id) {
        Deliveryman deliverList = dServices.findById(id);

        return ResponseEntity.ok().body(deliverList.getPlacaVeiculo());

    }

}

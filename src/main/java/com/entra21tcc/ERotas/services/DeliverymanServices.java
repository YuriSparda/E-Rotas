package com.entra21tcc.ERotas.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21tcc.ERotas.entities.Deliveryman;
import com.entra21tcc.ERotas.repositories.DeliverymanRepository;

@Service
public class DeliverymanServices {
    @Autowired
    private DeliverymanRepository dRepository;

    public List<Deliveryman> findAll() {
        return dRepository.findAll();
    }

    public Deliveryman findById(Integer id) {
        Optional<Deliveryman> client = dRepository.findById(id);
        return client.orElseThrow(
                () -> new ObjectNotFoundException(
                        "Objeto não encontrado! Id: " + id + ", Tipo: " + Deliveryman.class.getName(), null));
    }
}

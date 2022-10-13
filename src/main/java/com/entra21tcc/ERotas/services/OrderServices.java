package com.entra21tcc.ERotas.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21tcc.ERotas.entities.Order;
import com.entra21tcc.ERotas.repositories.OrderRepository;

@Service
public class OrderServices {
    @Autowired
    private OrderRepository oRepository;

    public List<Order> findAll() {
        return oRepository.findAll();
    }

    public Order findById(Integer id) {
        Optional<Order> client = oRepository.findById(id);
        return client.orElseThrow(
                () -> new ObjectNotFoundException(
                        "Objeto não encontrado! Id: " + id + ", Tipo: " + Order.class.getName(), null));
    }
}

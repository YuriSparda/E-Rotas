package com.entra21tcc.ERotas.controllers;

import java.net.URI;
//import java.time.Instant;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.entra21tcc.ERotas.entities.Order;
//import com.entra21tcc.ERotas.entities.stts;
import com.entra21tcc.ERotas.repositories.OrderRepository;
import com.entra21tcc.ERotas.services.OrderServices;

@RestController
@RequestMapping(value = "/Orders")
public class OrderController {

    @Autowired
    private OrderRepository cRepository;

    @Autowired
    private OrderServices cServices;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> OrderList = cServices.findAll();
        return ResponseEntity.ok().body(OrderList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Integer id) {
        Order OrderList = cServices.findById(id);
        return ResponseEntity.ok().body(OrderList);
    }

    @PostMapping(value = "/newOrder")
    public ResponseEntity<Order> insOrder(@Valid @RequestBody Order pOrder) {
        pOrder.setIdOrder(null);
        cRepository.save(pOrder);
        URI yURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pOrder.getIdOrder())
                .toUri();
        return ResponseEntity.created(yURI).body(pOrder);
    }

    /*
     * @PutMapping(value = "/OrderDelivered")
     * public ResponseEntity<Order> getTime() {
     * List<Order> selectedOrder = cServices.findAll();
     * for (Order order : selectedOrder) {
     * if (order.getOrderStts() == stts.DELIVERED) {
     * order.setDelivered(Instant.now());
     * }
     * 
     * return ResponseEntity.ok().body(order);
     * }
     * throw new IllegalArgumentException("tem algo errado ai colega");
     * 
     * }
     */

}

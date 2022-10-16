package com.entra21tcc.ERotas.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_Order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrder;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd  'T'  HH:mm  'Z'", timezone = "GMT-3")
    private Instant moment;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd  'T'  HH:mm  'Z'", timezone = "GMT-3")
    private Instant delivered;

    private stts orderStts;

    @ManyToOne
    @JoinColumn(name = "Client_id")
    private Client user;

    @ManyToOne
    @JoinColumn(name = "idDeliverman")
    private Deliveryman deliver;

    public Order(Integer idOrder, Instant moment, Instant delivered, Client user, Deliveryman deliver, stts orderStts) {
        this.idOrder = idOrder;
        this.moment = moment;
        this.user = user;
        this.deliver = deliver;
        this.delivered = delivered;
        this.orderStts = orderStts;
    }

    public Order() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idOrder == null) ? 0 : idOrder.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (idOrder == null) {
            if (other.idOrder != null)
                return false;
        } else if (!idOrder.equals(other.idOrder))
            return false;
        return true;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Client getUser() {
        return user;
    }

    public void setUser(Client user) {
        this.user = user;
    }

    public Deliveryman getDeliver() {
        return deliver;
    }

    public void setDeliver(Deliveryman deliver) {
        this.deliver = deliver;
    }

    public stts getOrderStts() {
        return orderStts;
    }

    public void setOrderStts(stts orderStts) {
        this.orderStts = orderStts;
    }

    public Instant getDelivered() {
        return delivered;
    }

    public void setDelivered(Object obj) {
        this.delivered=Instant.now();
    }

}
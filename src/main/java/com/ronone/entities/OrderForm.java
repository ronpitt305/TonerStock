package com.ronone.entities;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "toner_order")
public class OrderForm {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "OID")
    private int oid;

    @ManyToOne
    @JoinColumn(name = "BUYER_ID")
    private Buyer buyer;

    @OneToMany(targetEntity = Toner.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Toner> toner;

    public OrderForm() {
    }

    public OrderForm(Buyer buyer, List<Toner> toner) {
        this.buyer = buyer;
        this.toner = toner;
    }

    @Override
    public String toString() {
        return "OrderForm{" +
                "oid=" + oid +
                ", buyer=" + buyer +
                ", toner=" + toner +
                '}';
    }
}
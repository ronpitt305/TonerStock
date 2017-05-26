package com.ronone.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(schema = "toner_buyer")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BUYER_ID")
    private Long buyerId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "BUYER_ADDRESS")
    private String buyerAddress;

    @OneToMany(targetEntity = OrderForm.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "buyer")
    private List<OrderForm> orders;

    @OneToOne
    @JoinColumn(name = "TRANS_NUMBER")
    private Balances balances;

    public Buyer(){}

    public Buyer(String firstName, String lastName, String buyerAddress, Set<Toner> buyerToner) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.buyerAddress = buyerAddress;
    }


    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

}




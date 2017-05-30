package com.ronone.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(schema = "toner_buyer", name = "buyer")
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


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "TONER_ID")
    private Set<Toner> toners;

    @OneToOne
    @JoinColumn(name = "TRANS_NUMBER")
    private Balances balances;

    public Buyer(){}

    public Buyer(String firstName, String lastName, String buyerAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.buyerAddress = buyerAddress;
    }

    public Buyer(String firstName, String lastName, String buyerAddress, Set<Toner> toners, Balances balances) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.buyerAddress = buyerAddress;
        this.toners = toners;
        this.balances = balances;
    }

    public Set<Toner> getToners() {
        return toners;
    }

    public void setToners(Set<Toner> toners) {
        this.toners = toners;
    }

    public Balances getBalances() {
        return balances;
    }

    public void setBalances(Balances balances) {
        this.balances = balances;
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




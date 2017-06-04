package com.ronone.entities;

import javax.persistence.*;
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

    @Column(name = "BUYER_BALANCE")
    private int balance;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "buyer")
    private Set<Toner> toners;


    public Buyer(){}

    public Buyer(String firstName, String lastName, String buyerAddress, int balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.buyerAddress = buyerAddress;
        this.balance = balance;
    }

    public Buyer(String firstName, String lastName, String buyerAddress, int balance, Set<Toner> toners) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.buyerAddress = buyerAddress;
        this.balance = balance;
        this.toners = toners;
    }

    public Set<Toner> getToners() {
        return toners;
    }

    public void setToners(Set<Toner> toners) {
        this.toners = toners;
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}




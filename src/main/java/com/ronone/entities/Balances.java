package com.ronone.entities;

import javax.persistence.*;

@Entity
@Table(schema = "toner_balance")
public class Balances {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRANS_NUMBER")
    private Long transNumber;

    @OneToOne(targetEntity = Buyer.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Buyer buyer;

    @Column(name = "ACCOUNT_BALANCE")
    private Long accountBalance;

    @Column(name = "AMOUNT_PAID")
    private Long amountPaid;

    public Balances() {
    }

    public Balances(Long accountBalance, Long amountPaid) {
        this.accountBalance = accountBalance;
        this.amountPaid = amountPaid;
    }

    @Override
    public String toString() {
        return "Balances{" +
                "transNumber=" + transNumber +
                ", accountBalance=" + accountBalance +
                ", amountPaid=" + amountPaid +
                ", buyer=" + //buyer +
                '}';
    }

    public Long getTransNumber() {
        return transNumber;
    }

    public void setTransNumber(Long transNumber) {
        this.transNumber = transNumber;
    }

    public Long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Long accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Long getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Long amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
}

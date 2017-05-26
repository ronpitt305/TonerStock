package com.ronone.entities;

import javax.persistence.*;

@Entity
public class Balances {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRANS_NUMBER")
    private Long transNumber;

    @Column(name = "ACCOUNT_BALANCE")
    private Long accountBalance;

    @Column(name = "AMOUNT_PAID")
    private Long amountPaid;

    @OneToOne(targetEntity = Buyer.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "balances")
    private Buyer buyer;

    public Balances() {
    }

    public Balances(Long accountBalance, Long amountPaid) {
        this.accountBalance = accountBalance;
        this.amountPaid = amountPaid;
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
}

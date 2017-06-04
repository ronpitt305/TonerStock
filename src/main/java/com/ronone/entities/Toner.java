package com.ronone.entities;

import org.hibernate.id.UUIDGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(schema = "toner_stock")
public class Toner {

    @Id
    @Column(name = "TONER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TONER_NAME")
    private String tonerName;

    @Column(name = "TONER_PRICE")
    private int tonerPrice;

    @Column(name = "TONER_QUANTITY")
    private int tonerQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUYER_ID")
    private Buyer buyer;

    public Toner(){}

    public Toner(long tonerId){
        this.id = tonerId;
    }

    public Toner(String tonerName, int tonerPrice, int tonerQuantity) {
        this.tonerName = tonerName;
        this.tonerPrice = tonerPrice;
        this.tonerQuantity = tonerQuantity;
    }

    @Override
    public String toString() {
        return "Toner{" +
                "id=" + id +
                ", tonerName='" + tonerName + '\'' +
                ", tonerPrice=" + tonerPrice +
                ", tonerQuantity=" + tonerQuantity +
                '}';
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTonerName() {
        return tonerName;
    }

    public void setTonerName(String tonerName) {
        this.tonerName = tonerName;
    }

    public int getTonerPrice() {
        return tonerPrice;
    }

    public void setTonerPrice(int tonerPrice) {
        this.tonerPrice = tonerPrice;
    }

    public int getTonerQuantity() {
        return tonerQuantity;
    }

    public void setTonerQuantity(int tonerQuantity) {
        this.tonerQuantity = tonerQuantity;
    }
}

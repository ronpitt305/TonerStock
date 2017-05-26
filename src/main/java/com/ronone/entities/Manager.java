package com.ronone.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(schema = "toner_manager")
public class Manager {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "MANG_ID")
    private Long mid;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;


    public Manager(){
    }

    public Manager(String firstName, String lastName, Set<Buyer> buyers) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getMid() {
        return mid;
    }


    public void setMid(Long mid) {
        this.mid = mid;
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

}

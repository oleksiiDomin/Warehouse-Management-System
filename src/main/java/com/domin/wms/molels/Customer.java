package com.domin.wms.molels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Coil> coils;

    public Customer() {
        //
    }

    public Customer(int id, String companyName, String country, String city, List<Order> orders, List<Coil> coils) {
        this.id = id;
        this.companyName = companyName;
        this.country = country;
        this.city = city;
        this.orders = orders;
        this.coils = coils;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Coil> getCoils() {
        return coils;
    }

    public void setCoils(List<Coil> coils) {
        this.coils = coils;
    }
}

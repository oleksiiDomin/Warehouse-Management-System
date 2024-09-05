package com.domin.wms.molels;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "coils")
public class Coil {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number")
    @NotEmpty(message = "Enter number")
    private int number;

    @Column(name = "type")
    @NotEmpty(message = "Enter type")
    private String type;

    @Column(name = "length")
    @NotEmpty(message = "Enter length")
    @Min(value = 100, message = "Length should be at least 100 m.")
    @Max(value = 10000, message = "Length should be at last 10000 m.")
    private int length;

    @Column(name = "filling")
    @NotEmpty(message = "Enter filling")
    @Min(value = 10, message = "Filling should be at least 10 g.")
    @Max(value = 1500, message = "Filling should be at last 1500 g.")
    private int filling;

    @Column(name = "metal_shell")
    @NotEmpty(message = "Enter metal shell")
    @Min(value = 10, message = "Metal shell should be at least 10 g.")
    @Max(value = 1500, message = "Metal shell should be at last 1500 g.")
    private int metalShell;

    @Column(name = "weight")
    @NotEmpty(message = "Enter weight")
    @Min(value = 10, message = "Weight should be at least 10 kg.")
    @Max(value = 1500, message = "Weight should be at last 4500 kg.")
    private int weight;

    @Column(name = "shipping_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date shippingDate;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;



    public Coil() {
    }

    public Coil(int number, String type, int length, int filling, int metalShell, int weight, Date shippingDate, Order order, Customer customer) {
        this.number = number;
        this.type = type;
        this.length = length;
        this.filling = filling;
        this.metalShell = metalShell;
        this.weight = weight;
        this.shippingDate = shippingDate;
        this.order = order;
        this.customer = customer;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getFilling() {
        return filling;
    }

    public void setFilling(int filling) {
        this.filling = filling;
    }

    public int getMetalShell() {
        return metalShell;
    }

    public void setMetalShell(int metalShell) {
        this.metalShell = metalShell;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

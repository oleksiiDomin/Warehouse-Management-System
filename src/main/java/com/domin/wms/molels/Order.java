package com.domin.wms.molels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "lot")
    @NotEmpty(message = "Enter lot")
    @Size(min = 2, message = "Lot should contain at least 2 characters.")
    @Size(max = 20, message = "Lot should contain at last 20 characters.")
    private String lot;

    @Column(name = "type")
    @NotEmpty(message = "Enter type")
    private String type;

    @Column(name = "shipping_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date shippingDate;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @JsonIgnore
    @OneToMany(mappedBy = "order")
    private List<Coil> coils;

    public Order() {
    }

    public Order(int id, String lot, Customer customer, String type, Date shippingDate, List<Coil> coils) {
        this.id = id;
        this.lot = lot;
        this.customer = customer;
        this.type = type;
        this.shippingDate = shippingDate;
        this.coils = coils;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCoils(List<Coil> coils) {
        this.coils = coils;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public void setType(String type) {
        this.type = type;
    }
}

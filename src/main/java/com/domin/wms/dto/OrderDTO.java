package com.domin.wms.dto;

import com.domin.wms.molels.Customer;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class OrderDTO {

    @NotEmpty(message = "Enter lot")
    @Size(min = 2, message = "Lot should contain at least 2 characters.")
    @Size(max = 20, message = "Lot should contain at last 20 characters.")
    private String lot;

    @NotEmpty(message = "Enter type")
    private String type;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date shippingDate;

    private Customer customer;



    public OrderDTO() {
    }

    public OrderDTO(String lot, String type, Date shippingDate, Customer customer) {
        this.lot = lot;
        this.type = type;
        this.shippingDate = shippingDate;
        this.customer = customer;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

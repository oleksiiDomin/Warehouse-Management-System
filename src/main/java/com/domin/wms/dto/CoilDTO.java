package com.domin.wms.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;

public class CoilDTO {

    @NotEmpty(message = "Enter number")
    private int number;

    @NotEmpty(message = "Enter type")
    private String type;

    @NotEmpty(message = "Enter length")
    @Min(value = 100, message = "Length should be at least 100 m.")
    @Max(value = 10000, message = "Length should be at last 10000 m.")
    private int length;

    @NotEmpty(message = "Enter filling")
    @Min(value = 10, message = "Filling should be at least 10 g.")
    @Max(value = 1500, message = "Filling should be at last 1500 g.")
    private int filling;

    @NotEmpty(message = "Enter metal shell")
    @Min(value = 10, message = "Metal shell should be at least 10 g.")
    @Max(value = 1500, message = "Metal shell should be at last 1500 g.")
    private int metalShell;

    @NotEmpty(message = "Enter weight")
    @Min(value = 10, message = "Weight should be at least 10 kg.")
    @Max(value = 1500, message = "Weight should be at last 4500 kg.")
    private int weight;

    private Date shippingDate;



    public CoilDTO() {
    }

    public CoilDTO(int number, String type, int length, int filling, int metalShell, int weight, Date shippingDate) {
        this.number = number;
        this.type = type;
        this.length = length;
        this.filling = filling;
        this.metalShell = metalShell;
        this.weight = weight;
        this.shippingDate = shippingDate;
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
}

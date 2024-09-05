package com.domin.wms.dto.raw_materials_dto;

import com.domin.wms.molels.Provider;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class RawMaterialDTO {

    private int id;

    @Size(min = 2, message = "Lot should contain at least 2 characters.")
    @Size(max = 20, message = "Lot should contain at last 20 characters.")
    private String lot;

    private Provider provider;

    @Max(value = 1500000, message = "Balance should be at last 1500000 kg.")
    private int balance;

    @Column(name = "weight_of_lot")
    @Min(value = 1, message = "Weight should be at least 1 kg.")
    @Max(value = 50000, message = "Weight should be at last 50000 kg.")
    private int weightOfLot;

    private LocalDate supplyDate;



    public RawMaterialDTO() {
    }

    public RawMaterialDTO(int id, String lot, Provider provider, int balance, int weightOfLot, LocalDate supplyDate) {
        this.id = id;
        this.lot = lot;
        this.provider = provider;
        this.balance = balance;
        this.weightOfLot = weightOfLot;
        this.supplyDate = supplyDate;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getWeightOfLot() {
        return weightOfLot;
    }

    public void setWeightOfLot(int weightOfLot) {
        this.weightOfLot = weightOfLot;
    }

    public LocalDate getSupplyDate() {
        return supplyDate;
    }

    public void setSupplyDate(LocalDate supplyDate) {
        this.supplyDate = supplyDate;
    }


    @Override
    public String toString() {
        return "RawMaterialDTO{" +
                "id=" + id +
                ", lot='" + lot + '\'' +
                ", provider=" + provider +
                ", balance=" + balance +
                ", weightOfLot=" + weightOfLot +
                ", supplyDate=" + supplyDate +
                '}';
    }
}

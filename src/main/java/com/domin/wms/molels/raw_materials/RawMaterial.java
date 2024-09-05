package com.domin.wms.molels.raw_materials;

import com.domin.wms.molels.Provider;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "raw_material")
@Inheritance(strategy = InheritanceType.JOINED)
public class RawMaterial {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "lot")
    @Size(min = 2, message = "Lot should contain at least 2 characters.")
    @Size(max = 20, message = "Lot should contain at last 20 characters.")
    @NotEmpty(message = "Enter lot")
    private String lot;

    @ManyToOne
    @JoinColumn(name = "provider_id", referencedColumnName = "id")
    private Provider provider;

    @Column(name = "balance")
    @Min(value = 0, message = "Weight should be at least 0 kg.")
    @Max(value = 1500000, message = "Balance should be at last 1500000 kg.")
    private int balance;

    @Column(name = "weight_of_lot")
    @Min(value = 1, message = "Weight should be at least 1 kg.")
    @Max(value = 50000, message = "Weight should be at last 50000 kg.")
    @NotEmpty(message = "Enter model")
    private int weightOfLot;

    @Column(name = "supply_date")
    @Temporal(TemporalType.DATE)
    private LocalDate supplyDate;



    public RawMaterial() {
    }

    public RawMaterial(int id, String lot, Provider provider, int balance, int weightOfLot, LocalDate supplyDate) {
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
        return "RawMaterial{" +
                "id=" + id +
                ", lot='" + lot + '\'' +
                ", provider=" + provider +
                ", balance=" + balance +
                ", weightOfLot=" + weightOfLot +
                ", supplyDate=" + supplyDate +
                '}';
    }
}

package com.domin.wms.molels.raw_materials;

import com.domin.wms.molels.Provider;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "metal_shot")
public class MetalShot extends RawMaterial {

    @Column(name = "diameter")
    @DecimalMin(value = "0.1", message = "Diameter should be at least 0.1 mm.")
    @DecimalMax(value = "2.0", message = "Diameter should be at last 0.1 mm.")
    private double diameter;



    public MetalShot() {
    }

    public MetalShot(int id, String lot, Provider provider, int balance, int weightOfLot, LocalDate supplyDate, double diameter) {
        super(id, lot, provider, balance, weightOfLot, supplyDate);
        this.diameter = diameter;
    }



    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }
}

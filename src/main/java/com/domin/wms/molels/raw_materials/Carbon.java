package com.domin.wms.molels.raw_materials;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

@Entity
@Table(name = "carbon")
public class Carbon extends RawMaterial {

    @Column(name = "carbon")
    @DecimalMin(value = "0.1", message = "Carbon should be at least 0.1 %")
    @DecimalMax(value = "100.0", message = "Carbon should be at last 100.0 %")
    private double carbon;

    @Column(name = "sulfur")
    @DecimalMin(value = "0.1", message = "Sulfur should be at least 0.1 %")
    @DecimalMax(value = "100.0", message = "Sulfur should be at last 100.0 %")
    private double sulfur;



    public Carbon() {
    }

    public Carbon(double carbon, double sulfur) {
        this.carbon = carbon;
        this.sulfur = sulfur;
    }



    public double getCarbon() {
        return carbon;
    }

    public void setCarbon(double carbon) {
        this.carbon = carbon;
    }

    public double getSulfur() {
        return sulfur;
    }

    public void setSulfur(double sulfur) {
        this.sulfur = sulfur;
    }

    @Override
    public String toString() {
        return "Carbon{" +
                "carbon=" + carbon +
                ", sulfur=" + sulfur +
                '}';
    }
}

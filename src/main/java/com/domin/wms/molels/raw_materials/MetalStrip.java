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
@Table(name = "metal_strip")
public class MetalStrip extends RawMaterial {

    @Column(name = "thickness")
    @DecimalMin(value = "0.1", message = "Thickness should be at least 0.1 mm.")
    @DecimalMax(value = "2.0", message = "Thickness should be at last 2.0 mm.")
    private double thickness;

    @Column(name = "width")
    @DecimalMin(value = "55.0", message = "Width should be at least 0.1 mm.")
    @DecimalMax(value = "58.0", message = "Width should be at last 2.0 mm.")
    private double width;



    public MetalStrip() {
    }

    public MetalStrip(int id, String lot, Provider provider, int balance, int weightOfLot, LocalDate supplyDate, double thickness, double width) {
        super(id, lot, provider, balance, weightOfLot, supplyDate);
        this.thickness = thickness;
        this.width = width;
    }



    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}

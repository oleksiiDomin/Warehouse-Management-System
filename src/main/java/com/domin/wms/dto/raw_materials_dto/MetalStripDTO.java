package com.domin.wms.dto.raw_materials_dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

public class MetalStripDTO extends RawMaterialDTO {

    @DecimalMin(value = "0.1", message = "Thickness should be at least 0.1 mm.")
    @DecimalMax(value = "2.0", message = "Thickness should be at last 2.0 mm.")
    private double thickness;

    @DecimalMin(value = "55.0", message = "Width should be at least 0.1 mm.")
    @DecimalMax(value = "58.0", message = "Width should be at last 2.0 mm.")
    private double width;



    public MetalStripDTO() {
    }

    public MetalStripDTO(double thickness, double width) {
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

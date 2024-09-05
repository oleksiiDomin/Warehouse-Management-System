package com.domin.wms.dto.raw_materials_dto;

import com.domin.wms.dto.raw_materials_dto.RawMaterialDTO;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

public class MetalShotDTO extends RawMaterialDTO {

    @DecimalMin(value = "0.1", message = "Diameter should be at least 0.1 mm.")
    @DecimalMax(value = "2.0", message = "Diameter should be at last 0.1 mm.")
    private double diameter;



    public MetalShotDTO() {
    }

    public MetalShotDTO(double diameter) {
        this.diameter = diameter;
    }



    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }
}

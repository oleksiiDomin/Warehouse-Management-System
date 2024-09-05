package com.domin.wms.dto.raw_materials_dto;

import com.domin.wms.dto.raw_materials_dto.RawMaterialDTO;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

public class CarbonDTO extends RawMaterialDTO {

    @DecimalMin(value = "0.1", message = "Carbon should be at least 0.1 %")
    @DecimalMax(value = "100.0", message = "Carbon should be at last 100.0 %")
    private double carbon;

    @DecimalMin(value = "0.1", message = "Sulfur should be at least 0.1 %")
    @DecimalMax(value = "100.0", message = "Sulfur should be at last 100.0 %")
    private double sulfur;



    public CarbonDTO() {
    }

    public CarbonDTO(double carbon, double sulfur) {
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
}

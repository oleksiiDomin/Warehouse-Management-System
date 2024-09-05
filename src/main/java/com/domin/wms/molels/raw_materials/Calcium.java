package com.domin.wms.molels.raw_materials;

import com.domin.wms.molels.Provider;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "calcium")
public class Calcium extends RawMaterial {

    public Calcium() {
    }

}

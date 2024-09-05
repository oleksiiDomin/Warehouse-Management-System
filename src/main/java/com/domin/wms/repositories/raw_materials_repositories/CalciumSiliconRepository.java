package com.domin.wms.repositories.raw_materials_repositories;

import com.domin.wms.molels.raw_materials.CalciumSilicon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalciumSiliconRepository extends JpaRepository<CalciumSilicon, Integer> {
    //
}

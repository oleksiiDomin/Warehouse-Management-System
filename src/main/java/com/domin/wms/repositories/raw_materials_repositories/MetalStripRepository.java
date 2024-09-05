package com.domin.wms.repositories.raw_materials_repositories;

import com.domin.wms.molels.raw_materials.MetalStrip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetalStripRepository extends JpaRepository<MetalStrip, Integer> {
    //
}

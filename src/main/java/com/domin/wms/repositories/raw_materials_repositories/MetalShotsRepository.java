package com.domin.wms.repositories.raw_materials_repositories;

import com.domin.wms.molels.raw_materials.MetalShot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetalShotsRepository extends JpaRepository<MetalShot, Integer> {
    //
}

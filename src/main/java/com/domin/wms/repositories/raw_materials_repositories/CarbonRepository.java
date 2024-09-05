package com.domin.wms.repositories.raw_materials_repositories;

import com.domin.wms.molels.raw_materials.Carbon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarbonRepository extends JpaRepository<Carbon, Integer> {
    //
}

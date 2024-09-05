package com.domin.wms.repositories.raw_materials_repositories;

import com.domin.wms.molels.raw_materials.Calcium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalciumRepository extends JpaRepository<Calcium, Integer> {
    //
}

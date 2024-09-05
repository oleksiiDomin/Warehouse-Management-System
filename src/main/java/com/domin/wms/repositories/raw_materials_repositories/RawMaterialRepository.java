package com.domin.wms.repositories.raw_materials_repositories;

import com.domin.wms.molels.raw_materials.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RawMaterialRepository extends JpaRepository<RawMaterial, Integer> {
    List<RawMaterial> findAllByProviderId(int id);
}

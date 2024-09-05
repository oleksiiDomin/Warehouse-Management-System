package com.domin.wms.repositories;

import com.domin.wms.molels.Coil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoilRepository extends JpaRepository<Coil, Integer> {
    List<Coil> findAllByCustomer_Id(int id);
}

package com.domin.wms.services;

import com.domin.wms.molels.raw_materials.Carbon;
import com.domin.wms.repositories.raw_materials_repositories.CarbonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CarbonsService {
    private final CarbonRepository carbonRepository;

    @Autowired
    public CarbonsService(CarbonRepository carbonRepository) {
        this.carbonRepository = carbonRepository;
    }

    public List<Carbon> findAll() {
        return carbonRepository.findAll();
    }

    public Carbon findOne(int id) {
        return carbonRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Carbon carbon) {
        carbonRepository.save(carbon);
    }

    @Transactional
    public void update(Carbon updatedCarbon, int id) {
        updatedCarbon.setId(id);
        carbonRepository.save(updatedCarbon);
    }

    @Transactional
    public void delete(int id) {
        carbonRepository.deleteById(id);
    }
}

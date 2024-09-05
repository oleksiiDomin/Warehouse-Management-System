package com.domin.wms.services;

import com.domin.wms.molels.raw_materials.CalciumSilicon;
import com.domin.wms.repositories.raw_materials_repositories.CalciumSiliconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CalciumSiliconService {
    private final CalciumSiliconRepository calciumSiliconRepository;

    @Autowired
    public CalciumSiliconService(CalciumSiliconRepository calciumSiliconRepository) {
        this.calciumSiliconRepository = calciumSiliconRepository;
    }

    public List<CalciumSilicon> findAll() {
        return calciumSiliconRepository.findAll();
    }

    public CalciumSilicon findOne(int id) {
        return calciumSiliconRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(CalciumSilicon calciumSilicon) {
        calciumSiliconRepository.save(calciumSilicon);
    }

    @Transactional
    public void update(CalciumSilicon updatedCalciumSilicon, int id) {
        updatedCalciumSilicon.setId(id);
        calciumSiliconRepository.save(updatedCalciumSilicon);
    }

    @Transactional
    public void delete(int id) {
        calciumSiliconRepository.deleteById(id);
    }
}

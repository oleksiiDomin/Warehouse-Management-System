package com.domin.wms.services;

import com.domin.wms.molels.raw_materials.Calcium;
import com.domin.wms.repositories.raw_materials_repositories.CalciumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CalciumService {
    private final CalciumRepository calciumRepository;

    @Autowired
    public CalciumService(CalciumRepository calciumRepository) {
        this.calciumRepository = calciumRepository;
    }

    public List<Calcium> findAll() {
        return calciumRepository.findAll();
    }

    public Calcium findOne(int id) {
        return calciumRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Calcium calcium) {
        calciumRepository.save(calcium);
    }

    @Transactional
    public void update(Calcium updatedCalcium, int id) {
        updatedCalcium.setId(id);
        calciumRepository.save(updatedCalcium);
    }

    @Transactional
    public void delete(int id) {
        calciumRepository.deleteById(id);
    }
}

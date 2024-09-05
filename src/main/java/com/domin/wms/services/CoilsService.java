package com.domin.wms.services;

import com.domin.wms.molels.Coil;
import com.domin.wms.repositories.CoilRepository;
import com.domin.wms.util.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CoilsService {

    private final CoilRepository coilRepository;

    @Autowired
    public CoilsService(CoilRepository coilRepository) {
        this.coilRepository = coilRepository;
    }




    public List<Coil> findAll() {
        return coilRepository.findAll();
    }


    public Coil findOne(int id) {
        return coilRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }


    public List<Coil> findAllByCustomer(int id) {
        return coilRepository.findAllByCustomer_Id(id);
    }


    @Transactional
    public void save(Coil coil) {
        coilRepository.save(coil);
    }


    @Transactional
    public void update(Coil updatedCoil, int id) {
        updatedCoil.setId(id);
        coilRepository.save(updatedCoil);
    }
}
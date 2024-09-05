package com.domin.wms.services;

import com.domin.wms.molels.raw_materials.*;
import com.domin.wms.repositories.raw_materials_repositories.CalciumRepository;
import com.domin.wms.repositories.raw_materials_repositories.CalciumSiliconRepository;
import com.domin.wms.repositories.raw_materials_repositories.CarbonRepository;
import com.domin.wms.repositories.raw_materials_repositories.MetalShotsRepository;
import com.domin.wms.repositories.raw_materials_repositories.MetalStripRepository;
import com.domin.wms.repositories.raw_materials_repositories.RawMaterialRepository;
import com.domin.wms.util.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class RawMaterialService {

    private final RawMaterialRepository rawMaterialRepository;
    private final MetalStripRepository metalStripRepository;
    private final MetalShotsRepository metalShotsRepository;
    private final CarbonRepository carbonRepository;
    private final CalciumRepository calciumRepository;
    private final CalciumSiliconRepository calciumSiliconRepository;

    // ------------------------------------------------------------------- //

    @Autowired
    public RawMaterialService(RawMaterialRepository rawMaterialRepository,
                              MetalStripRepository metalStripRepository,
                              MetalShotsRepository metalShotsRepository,
                              CarbonRepository carbonRepository,
                              CalciumRepository calciumRepository,
                              CalciumSiliconRepository calciumSiliconRepository) {
        this.rawMaterialRepository = rawMaterialRepository;
        this.metalStripRepository = metalStripRepository;
        this.metalShotsRepository = metalShotsRepository;
        this.carbonRepository = carbonRepository;
        this.calciumRepository = calciumRepository;
        this.calciumSiliconRepository = calciumSiliconRepository;
    }


    // ------------------------------------------------------------------- //


    public List<RawMaterial> findAllRawMaterial() {
        return rawMaterialRepository.findAll();
    }

    public List<MetalStrip> findAllMetalStrip() {
        return metalStripRepository.findAll();
    }

    public List<MetalShot> findAllMetalShot() {
        return metalShotsRepository.findAll();
    }

    public List<Carbon> findAllCarbon() {return carbonRepository.findAll();}

    public List<Calcium> findAllCalcium() {return calciumRepository.findAll();}

    public List<CalciumSilicon> findAllCalciumSilicon() {return calciumSiliconRepository.findAll();}


    // ------------------------------------------------------------------- //


    public MetalStrip findMetalStripById(int id) {
        return metalStripRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public MetalShot findMetalShotById(int id) {
        return metalShotsRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Carbon findCarbonById(int id) {
        return carbonRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Calcium findCalciumById(int id) {
        return calciumRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public CalciumSilicon findCalciumSiliconById(int id) {
        return calciumSiliconRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }


    // ------------------------------------------------------------------- //


    public List<RawMaterial> findAllByProvider(int id) {
        return rawMaterialRepository.findAllByProviderId(id);
    }


    // ------------------------------------------------------------------- //


    @Transactional
    public void save(MetalStrip metalStrip) {
        setDate(metalStrip);
        metalStripRepository.save(metalStrip);
    }

    @Transactional
    public void save(MetalShot metalShot) {
        setDate(metalShot);
        metalShotsRepository.save(metalShot);
    }

    @Transactional
    public void save(Carbon carbon) {
        setDate(carbon);
        carbonRepository.save(carbon);
    }

    @Transactional
    public void save(Calcium calcium) {
        setDate(calcium);
        calciumRepository.save(calcium);
    }

    @Transactional
    public void save(CalciumSilicon calciumSilicon) {
        setDate(calciumSilicon);
        calciumSiliconRepository.save(calciumSilicon);
    }


    // ------------------------------------------------------------------- //


    @Transactional
    public void update(MetalStrip updatedMetalStrip, int id) {
        updatedMetalStrip.setId(id);
        metalStripRepository.save(updatedMetalStrip);
    }

    @Transactional
    public void update(MetalShot updatedMetalShot, int id) {
        updatedMetalShot.setId(id);
        metalShotsRepository.save(updatedMetalShot);
    }

    @Transactional
    public void update(Carbon updatedCarbon, int id) {
        updatedCarbon.setId(id);
        carbonRepository.save(updatedCarbon);
    }

    @Transactional
    public void update(Calcium updatedCalcium, int id) {
        updatedCalcium.setId(id);
        calciumRepository.save(updatedCalcium);
    }

    @Transactional
    public void update(CalciumSilicon updatedCalciumSilicon, int id) {
        updatedCalciumSilicon.setId(id);
        calciumSiliconRepository.save(updatedCalciumSilicon);
    }


    // ------------------------------------------------------------------- //


    @Transactional
    public void delete(int id) {
        rawMaterialRepository.deleteById(id);
    }


    // ------------------------------------------------------------------- //


    private void setDate(RawMaterial rawMaterial) {
        rawMaterial.setSupplyDate(LocalDate.now());
    }


}

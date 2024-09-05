package com.domin.wms.services;

import com.domin.wms.molels.Provider;
import com.domin.wms.repositories.ProviderRepository;
import com.domin.wms.util.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProvidersService {
    private final ProviderRepository providerRepository;

    @Autowired
    public ProvidersService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public List<Provider> findAll() {
        return providerRepository.findAll();
    }

    public Provider findOne(int id) {
        return providerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public void save(Provider provider) {
        providerRepository.save(provider);
    }

    @Transactional
    public void update(Provider updatedProvider, int id) {
        updatedProvider.setId(id);
        providerRepository.save(updatedProvider);
    }

    @Transactional
    public void delete(int id) {
        providerRepository.deleteById(id);
    }
}

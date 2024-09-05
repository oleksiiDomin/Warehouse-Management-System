package com.domin.wms.controllers;

import com.domin.wms.dto.ProviderDTO;
import com.domin.wms.molels.Provider;
import com.domin.wms.services.ProvidersService;
import com.domin.wms.util.EntityErrorMassage;
import com.domin.wms.util.exceptions.EntityErrorResponse;
import com.domin.wms.util.exceptions.EntityNotFoundException;
import com.domin.wms.util.exceptions.EntityNotValidException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/providers")
@RequiredArgsConstructor
public class ProvidersController {

    private final ProvidersService providersService;
    private final EntityErrorMassage entityErrorMassage;



    @GetMapping()
    public List<ProviderDTO> getProviders() {
        return getProviderDTOList(providersService.findAll());
    }



    @GetMapping("/{id}")
    public ProviderDTO getProvider(@PathVariable("id") int id) {
        return convertToProviderDTO(providersService.findOne(id));
    }



    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid ProviderDTO providerDTO,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            entityErrorMassage.sentMassage(bindingResult);

        providersService.save(convertToProvider(providerDTO));

        return ResponseEntity.ok(HttpStatus.CREATED);
    }



    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody @Valid ProviderDTO providerDTO,
                                             BindingResult bindingResult,
                                             @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            entityErrorMassage.sentMassage(bindingResult);

        providersService.update(convertToProvider(providerDTO), id);

        return ResponseEntity.ok(HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        providersService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }



    private ProviderDTO convertToProviderDTO(Provider provider) {
        ProviderDTO providerDTO = new ProviderDTO();

        providerDTO.setCity(provider.getCity());
        providerDTO.setCompanyName(provider.getCompanyName());
        providerDTO.setCountry(provider.getCountry());

        return providerDTO;
    }

    private Provider convertToProvider(ProviderDTO providerDTO) {
        Provider provider = new Provider();

        provider.setCompanyName(providerDTO.getCompanyName());
        provider.setCity(providerDTO.getCity());
        provider.setCountry(providerDTO.getCountry());

        return provider;
    }

    private List<ProviderDTO> getProviderDTOList(List<Provider> list) {
        List<ProviderDTO> providers = new ArrayList<>();

        for (Provider provider : providersService.findAll()) {
            providers.add(convertToProviderDTO(provider));
        }

        return providers;
    }

    @ExceptionHandler
    private ResponseEntity<EntityErrorResponse> handleException(EntityNotFoundException e) {
        EntityErrorResponse response = new EntityErrorResponse(
                "Object with this Id wasn't found.",
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    private ResponseEntity<EntityErrorResponse> handleException(EntityNotValidException e) {
        EntityErrorResponse response = new EntityErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

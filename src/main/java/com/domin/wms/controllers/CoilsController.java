package com.domin.wms.controllers;

import com.domin.wms.dto.CoilDTO;
import com.domin.wms.molels.Coil;
import com.domin.wms.services.CoilsService;
import com.domin.wms.util.EntityErrorMassage;
import com.domin.wms.util.exceptions.EntityErrorResponse;
import com.domin.wms.util.exceptions.EntityNotFoundException;
import com.domin.wms.util.exceptions.EntityNotValidException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/coils")
@RequiredArgsConstructor
public class CoilsController {

    private final CoilsService coilsService;
    private final EntityErrorMassage entityErrorMassage;
    private final ModelMapper modelMapper;



    @GetMapping()
    public List<CoilDTO> getAllCoils() {
        return convertToCoilDTOList(coilsService.findAll());
    }



    @GetMapping("/{id}")
    public CoilDTO getCoilById(@PathVariable("id") int id) {
        return convertToDTO(coilsService.findOne(id));
    }



    @GetMapping("find_by_customer/{id}")
    public List<CoilDTO> getCoilsByCustomerId(@PathVariable("id") int id) {
        return convertToCoilDTOList(coilsService.findAllByCustomer(id));
    }



    @PostMapping()
    public ResponseEntity<HttpStatus> createOneCoil(@RequestBody @Valid List<@Valid CoilDTO> coilsDTO,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            entityErrorMassage.sentMassage(bindingResult);

        for (CoilDTO coilDTO : coilsDTO)
            coilsService.save(convertFromDTO(coilDTO));

        return ResponseEntity.ok(HttpStatus.CREATED);
    }



    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@ModelAttribute("coil") CoilDTO coilDTO,
                                             @PathVariable("id") int id,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            entityErrorMassage.sentMassage(bindingResult);

        coilsService.update(convertFromDTO(coilDTO), id);
        return ResponseEntity.ok(HttpStatus.OK);
    }



    // ------------------------------------------------------------------- //
    // ------------------------------------------------------------------- //
    // ------------------------------------------------------------------- //



    private Coil convertFromDTO(CoilDTO coilDTO) {
        return modelMapper.map(coilDTO, Coil.class);
    }


    private CoilDTO convertToDTO(Coil coil) {
        return modelMapper.map(coil, CoilDTO.class);
    }


    private List<CoilDTO> convertToCoilDTOList(List<Coil> list) {
        List<CoilDTO> orders = new ArrayList<>();

        for (Coil coil : list) {
            orders.add(convertToDTO(coil));
        }

        return orders;
    }


    // ------------------------------------------------------------------- //
    // ------------------------------------------------------------------- //
    // ------------------------------------------------------------------- //


    @ExceptionHandler
    private ResponseEntity<EntityErrorResponse> handleException(EntityNotFoundException e) {
        EntityErrorResponse response = new EntityErrorResponse(
                "Entity wasn't found.",
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

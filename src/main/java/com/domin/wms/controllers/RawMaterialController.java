package com.domin.wms.controllers;

import com.domin.wms.dto.raw_materials_dto.*;
import com.domin.wms.molels.raw_materials.*;
import com.domin.wms.services.RawMaterialService;
import com.domin.wms.util.EntityErrorMassage;
import com.domin.wms.util.exceptions.EntityErrorResponse;
import com.domin.wms.util.exceptions.EntityNotFoundException;
import com.domin.wms.util.exceptions.EntityNotValidException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/raw_materials")
@RequiredArgsConstructor
public class RawMaterialController {

    private final RawMaterialService rawMaterialService;
    private final EntityErrorMassage entityErrorMassage;
    private final ModelMapper modelMapper;



    @GetMapping("/{type}")
    public List<? extends RawMaterialDTO> getAllRawMaterial(@PathVariable("type") String type) {
        return switch (type) {
            case "metal_strip" -> convertToDTOList(rawMaterialService.findAllMetalStrip(), rawMaterial -> convertToDTO(rawMaterial, MetalStripDTO.class));
            case "metal_shot" -> convertToDTOList(rawMaterialService.findAllMetalShot(), rawMaterial -> convertToDTO(rawMaterial, MetalShotDTO.class));
            case "carbon" -> convertToDTOList(rawMaterialService.findAllCarbon(), rawMaterial -> convertToDTO(rawMaterial, CarbonDTO.class));
            case "calcium" -> convertToDTOList(rawMaterialService.findAllCalcium(), rawMaterial -> convertToDTO(rawMaterial, CalciumDTO.class));
            case "calcium-silicon" -> convertToDTOList(rawMaterialService.findAllCalciumSilicon(), rawMaterial -> convertToDTO(rawMaterial, CalciumSiliconDTO.class));
            default -> convertToDTOList(rawMaterialService.findAllRawMaterial(), rawMaterial -> convertToDTO(rawMaterial, RawMaterialDTO.class));
        };
    }



    @GetMapping("/{type}/{id}")
    public RawMaterialDTO getRawMaterialById(@PathVariable("type") String type, @PathVariable("id") int id) {
        return switch (type) {
            case "metal_strip" -> convertToDTO(rawMaterialService.findMetalStripById(id), MetalStripDTO.class);
            case "metal_shot" -> convertToDTO(rawMaterialService.findMetalShotById(id), MetalShotDTO.class);
            case "carbon" -> convertToDTO(rawMaterialService.findCarbonById(id), CarbonDTO.class);
            case "calcium" -> convertToDTO(rawMaterialService.findCalciumById(id), CalciumDTO.class);
            case "calcium_silicon" -> convertToDTO(rawMaterialService.findCalciumSiliconById(id), CalciumSiliconDTO.class);
            default -> throw new EntityNotFoundException();    ///// TODO
        };
    }


    // ------------------------------------------------------------------- //


    @GetMapping("/provider/{id}")
    public List<RawMaterialDTO> getRawMaterialsByProvider(@PathVariable("id") int id) {
        return convertToDTOList(rawMaterialService.findAllByProvider(id), rawMaterial -> convertToDTO(rawMaterial, RawMaterialDTO.class));
    }


    // ------------------------------------------------------------------- //


    @PostMapping("/create_metal_strip")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid MetalStripDTO metalStripDTO,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            entityErrorMassage.sentMassage(bindingResult);

        rawMaterialService.save(convertFromDTO(metalStripDTO, MetalStrip.class));

        return ResponseEntity.ok(HttpStatus.CREATED);
    }


    @PostMapping("/create_metal_shot")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid MetalShotDTO metalShotDTO,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            entityErrorMassage.sentMassage(bindingResult);

        rawMaterialService.save(convertFromDTO(metalShotDTO, MetalShot.class));

        return ResponseEntity.ok(HttpStatus.CREATED);
    }


    @PostMapping("/create_carbon")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid CarbonDTO carbonDTO,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            entityErrorMassage.sentMassage(bindingResult);

        rawMaterialService.save(convertFromDTO(carbonDTO, Carbon.class));

        return ResponseEntity.ok(HttpStatus.CREATED);
    }


    @PostMapping("/create_calcium")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid CalciumDTO calciumDTO,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            entityErrorMassage.sentMassage(bindingResult);

        rawMaterialService.save(convertFromDTO(calciumDTO, Calcium.class));

        return ResponseEntity.ok(HttpStatus.CREATED);
    }


    @PostMapping("/create_calcium_silicon")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid CalciumSiliconDTO calciumSiliconDTO,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            entityErrorMassage.sentMassage(bindingResult);

        rawMaterialService.save(convertFromDTO(calciumSiliconDTO, CalciumSilicon.class));

        return ResponseEntity.ok(HttpStatus.CREATED);
    }


    // ------------------------------------------------------------------- //
    // ------------------------------------------------------------------- //
    // ------------------------------------------------------------------- //


    @PatchMapping("/update_strip/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody @Valid MetalStripDTO metalStripDTO,
                                             BindingResult bindingResult,
                                             @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            entityErrorMassage.sentMassage(bindingResult);

        rawMaterialService.update(convertFromDTO(metalStripDTO, MetalStrip.class), id);

        return ResponseEntity.ok(HttpStatus.OK);
    }


    @PatchMapping("/update_shot/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody @Valid MetalShotDTO metalShotDTO,
                                             BindingResult bindingResult,
                                             @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            entityErrorMassage.sentMassage(bindingResult);

        rawMaterialService.update(convertFromDTO(metalShotDTO, MetalShot.class), id);

        return ResponseEntity.ok(HttpStatus.OK);
    }


    @PatchMapping("/update_carbon/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody @Valid CarbonDTO carbonDTO,
                                             BindingResult bindingResult,
                                             @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            entityErrorMassage.sentMassage(bindingResult);

        rawMaterialService.update(convertFromDTO(carbonDTO, Carbon.class), id);

        return ResponseEntity.ok(HttpStatus.OK);
    }


    @PatchMapping("/update_calcium/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody @Valid CalciumDTO calciumDTO,
                                             BindingResult bindingResult,
                                             @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            entityErrorMassage.sentMassage(bindingResult);

        rawMaterialService.update(convertFromDTO(calciumDTO, Calcium.class), id);

        return ResponseEntity.ok(HttpStatus.OK);
    }


    @PatchMapping("/update_calcium_silicon/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody @Valid CalciumSiliconDTO calciumSiliconDTO,
                                             BindingResult bindingResult,
                                             @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            entityErrorMassage.sentMassage(bindingResult);

        rawMaterialService.update(convertFromDTO(calciumSiliconDTO, CalciumSilicon.class), id);

        return ResponseEntity.ok(HttpStatus.OK);
    }


    // ------------------------------------------------------------------- //
    // ------------------------------------------------------------------- //
    // ------------------------------------------------------------------- //


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        rawMaterialService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    // ------------------------------------------------------------------- //
    // ------------------------------------------------------------------- //
    // ------------------------------------------------------------------- //


    private <T, U> List<U> convertToDTOList(List<T> list, Function<T, U> convertToDTO) {
        return list.stream()
                .map(convertToDTO)
                .collect(Collectors.toList());
    }


    private <T extends RawMaterialDTO> T convertToDTO(RawMaterial rawMaterial, Class<T> dtoClass) {
        return modelMapper.map(rawMaterial, dtoClass);
    }


    private <T extends RawMaterial> T convertFromDTO(RawMaterialDTO rawMaterialDTO, Class<T> entityClass) {
        return modelMapper.map(rawMaterialDTO, entityClass);
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





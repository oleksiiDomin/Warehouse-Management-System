package com.domin.wms.controllers;

import com.domin.wms.dto.OrderDTO;
import com.domin.wms.molels.Order;
import com.domin.wms.services.OrdersService;
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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {

    private final ModelMapper modelMapper;
    private final OrdersService ordersService;
    private final EntityErrorMassage entityErrorMassage;



    @GetMapping()
    public List<OrderDTO> getOrders() {
        return convertToDTOList(ordersService.findAll());
    }



    @GetMapping("by_customer_id/{id}")
    public List<OrderDTO> getOrdersByCustomerId(@PathVariable("id") int id) {
        return convertToDTOList(ordersService.findAllByCustomerId(id));
    }



    @GetMapping("/{id}")
    public OrderDTO getOrder(@PathVariable("id") int id) {
        return convertToDTO(ordersService.findOne(id));
    }



    @GetMapping("by_customer_id/{lot}")
    public OrderDTO getOrdersByLot(@PathVariable("lot") String lot) {
        return convertToDTO(ordersService.findByLot(lot));
    }



    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid OrderDTO orderDTO,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            entityErrorMassage.sentMassage(bindingResult);

        ordersService.save(convertFromDTO(orderDTO));

        return ResponseEntity.ok(HttpStatus.OK);
    }



    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody @Valid OrderDTO orderDTO,
                                             @PathVariable("id") int id,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            entityErrorMassage.sentMassage(bindingResult);

        ordersService.update(convertFromDTO(orderDTO), id);
        return ResponseEntity.ok(HttpStatus.OK);
    }



    // ------------------------------------------------------------------- //
    // ------------------------------------------------------------------- //
    // ------------------------------------------------------------------- //



    private OrderDTO convertToDTO(Order order) {
        return modelMapper.map(order, OrderDTO.class);
    }

    private Order convertFromDTO(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, Order.class);
    }

    private List<OrderDTO> convertToDTOList(List<Order> list) {
        List<OrderDTO> orders = new ArrayList<>();

        for (Order order : list) {
            orders.add(convertToDTO(order));
        }

        return orders;
    }


    // ------------------------------------------------------------------- //
    // ------------------------------------------------------------------- //
    // ------------------------------------------------------------------- //


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

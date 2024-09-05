package com.domin.wms.controllers;

import com.domin.wms.dto.CustomerDTO;
import com.domin.wms.molels.Customer;
import com.domin.wms.molels.Order;
import com.domin.wms.services.CustomerService;
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
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomersController {

    private final CustomerService customerService;
    private final EntityErrorMassage entityErrorMassage;
    private final ModelMapper modelMapper;



    @GetMapping()
    public List<CustomerDTO> getCustomers() {
        return getCustomerDTOList(customerService.findAll());
    }



    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable("id") int id) {
        return convertToCustomerDTO(customerService.findOne(id));
    }


    @GetMapping("/orders/{id}")
    public List<Order> getOrders(@PathVariable("id") int id) {
        Customer customer = customerService.findOne(id);

        return customer.getOrders();
    }


    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid CustomerDTO customerDTO,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            entityErrorMassage.sentMassage(bindingResult);

        customerService.save(convertToCustomer(customerDTO));

        return ResponseEntity.ok(HttpStatus.CREATED);
    }



    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody @Valid CustomerDTO customerDTO,
                                             BindingResult bindingResult,
                                             @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            entityErrorMassage.sentMassage(bindingResult);

        customerService.update(convertToCustomer(customerDTO), id);

        return ResponseEntity.ok(HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        customerService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }





    private List<CustomerDTO> getCustomerDTOList(List<Customer> list) {
        List<CustomerDTO> customers = new ArrayList<>();

        for (Customer customer : customerService.findAll()) {
            customers.add(convertToCustomerDTO(customer));
        }

        return customers;
    }

    private CustomerDTO convertToCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setCity(customer.getCity());
        customerDTO.setCompanyName(customer.getCompanyName());
        customerDTO.setCountry(customer.getCountry());

        return modelMapper.map(customer, CustomerDTO.class);
    }

    private Customer convertToCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();

        customer.setCompanyName(customerDTO.getCompanyName());
        customer.setCity(customerDTO.getCity());
        customer.setCountry(customerDTO.getCountry());

        return modelMapper.map(customerDTO, Customer.class);
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

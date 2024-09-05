package com.domin.wms.controllers;

import com.domin.wms.molels.User;
import com.domin.wms.services.UsersService;
import com.domin.wms.util.EntityErrorMassage;
import com.domin.wms.util.UserErrorResponse;
import com.domin.wms.util.UserNotValidException;
import com.domin.wms.util.UserNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;
    private final EntityErrorMassage entityErrorMassage;



    @GetMapping()
    public List<User> getUsers() {
        return usersService.findAll();
    }


    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") int id) {
        return usersService.findOne(id);
    }


    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid User user,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            entityErrorMassage.sentMassage(bindingResult);

        usersService.save(user);

        return ResponseEntity.ok(HttpStatus.OK);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody @Valid User user,
                                             BindingResult bindingResult,
                                             @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            entityErrorMassage.sentMassage(bindingResult);

        usersService.update(user, id);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        usersService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    // ------------------------------------------------------------------- //


    @ExceptionHandler
    private ResponseEntity<UserErrorResponse> handleException(UserNotFoundException e) {
        UserErrorResponse response = new UserErrorResponse(
                "User with this Id wasn't found.",
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<UserErrorResponse> handleException(UserNotValidException e) {
        UserErrorResponse response = new UserErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

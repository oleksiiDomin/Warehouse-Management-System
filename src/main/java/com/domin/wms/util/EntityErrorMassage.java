package com.domin.wms.util;

import com.domin.wms.util.exceptions.EntityNotValidException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public class EntityErrorMassage {

    public void sentMassage(BindingResult bindingResult) {
        StringBuilder errorMsg = new StringBuilder();

        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {
            errorMsg.append(error.getField())
                    .append(" - ")
                    .append(error.getDefaultMessage())
                    .append("; ----- ");
        }

        throw new EntityNotValidException(errorMsg.toString());
    }
}

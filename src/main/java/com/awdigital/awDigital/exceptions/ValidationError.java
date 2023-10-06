package com.awdigital.awDigital.exceptions;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError() {
        super();
    }

    public ValidationError(LocalDateTime timestemp, Integer status, String erro, String path) {
        super(timestemp, status, erro, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addErrors(String fieldName, String message) {
        this.errors.add(new FieldMessage(fieldName, message));
    }
}

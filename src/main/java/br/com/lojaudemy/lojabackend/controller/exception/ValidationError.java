package br.com.lojaudemy.lojabackend.controller.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    private static final long serialVersionUID = 1L;

    private List<FieldMessage> errorList = new ArrayList<>();

    public ValidationError(Long timeStamp, Integer status, String error, String message, String path) {
        super(timeStamp, status, error, message, path);
    }

    public List<FieldMessage> getErrors() {
        return errorList;
    }

    public void addErros(String fieldName, String message) {
        errorList.add(new FieldMessage(fieldName, message));
    }

}

package br.com.lojaudemy.lojabackend.controller.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    private static final long serialVersionUID = 1L;

    private List<FieldMessage> errorList = new ArrayList<>();

    public ValidationError(Integer status, String msg, Long timeStamp) {
        super(status, msg, timeStamp);
    }

    public List<FieldMessage> getErrors() {
        return errorList;
    }

    public void addErros(String fieldName, String message) {
        errorList.add(new FieldMessage(fieldName, message));
    }

}

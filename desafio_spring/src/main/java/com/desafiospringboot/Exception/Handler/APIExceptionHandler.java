package com.desafiospringboot.Exception.Handler;

import com.desafiospringboot.DTOs.ExceptionDTO;
import com.desafiospringboot.Exception.InvalidArgumentException;
import com.desafiospringboot.Exception.UserNotFoundException;
import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class APIExceptionHandler {
    private final MessageSource messageSource;

    @Autowired
    public APIExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionDTO>> defaultHandler(MethodArgumentNotValidException e){
        BindingResult result = e.getBindingResult();

        List<FieldError> fieldErrors = result.getFieldErrors();
        List<ExceptionDTO> processedFieldErrors = processFieldErrors(fieldErrors);

        return ResponseEntity.badRequest().body(processedFieldErrors);
    }

    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<ExceptionDTO> defaultHandler(JsonParseException e){
        return ResponseEntity.badRequest().body(new ExceptionDTO("Verifique a formatação do JSON"));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionDTO> defaultHandler(UserNotFoundException e){
        return ResponseEntity.badRequest().body(new ExceptionDTO(e.getMessage()));
    }

    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<ExceptionDTO> defaultHandler(InvalidArgumentException e){
        return ResponseEntity.badRequest().body(new ExceptionDTO(e.getMessage()));
    }

    private List<ExceptionDTO> processFieldErrors(List<FieldError> fieldErrors) {
        List<ExceptionDTO> dtosList = new ArrayList<>();

        for (FieldError fieldError: fieldErrors) {
            String errorMessage = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            dtosList.add(new ExceptionDTO(fieldError.getField(), errorMessage));
        }

        return dtosList;
    }
}

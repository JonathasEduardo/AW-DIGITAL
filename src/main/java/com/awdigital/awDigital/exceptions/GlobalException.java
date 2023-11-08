package com.awdigital.awDigital.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ObjectNoteFoundException.class)//Quando for lançada a excessão o metodo irá ser tratado
    public ResponseEntity<StandardError>objectNoteFoundException(ObjectNoteFoundException e, HttpServletRequest request){
        StandardError se = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),e.getMessage(),request.getRequestURI());{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
        }
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardError>illegalArgumentException(IllegalArgumentException e, HttpServletRequest request){
        StandardError se = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage(),request.getRequestURI());{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
        }
    }

    @ExceptionHandler(IllegalArgument.class)
    public ResponseEntity<StandardError>illegalArgument(IllegalArgument e, HttpServletRequest request){
        StandardError se = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage(),request.getRequestURI());{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
        }
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError>dataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request){
        StandardError se = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage(),request.getRequestURI());{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError>methodArgumentNotValidException(MethodArgumentNotValidException e,
                                                                          HttpServletRequest request ){
        ValidationError errors = new ValidationError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Erro na validação dos campos",request.getRequestURI());

        for (FieldError x: e.getBindingResult().getFieldErrors()){
            errors.addErrors(x.getField(),x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

}

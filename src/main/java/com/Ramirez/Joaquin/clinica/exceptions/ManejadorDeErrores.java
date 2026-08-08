package com.Ramirez.Joaquin.clinica.exceptions;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManejadorDeErrores {

    //1. Interceptar los errores de Validación
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> manejarErroresValidacion(MethodArgumentNotValidException exception) {
        Map<String, String> errores = new HashMap<>();

        // Recorremos todos los campos que fallaron y guardamos su mensaje
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errores.put(error.getField(), error.getDefaultMessage());
        });

        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST); // Código 400
    }

    //2. Interceptar los errores de lógica
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> manejarErroresNegocio(RuntimeException exception) {
        Map<String, String> errores = new HashMap<>();
        errores.put("mensaje", exception.getMessage());

        return new ResponseEntity<>(errores, HttpStatus.NOT_FOUND); // Código 404
    }

}

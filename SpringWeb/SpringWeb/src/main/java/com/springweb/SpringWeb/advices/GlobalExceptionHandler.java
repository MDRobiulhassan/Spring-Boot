package com.springweb.SpringWeb.advices;

import com.springweb.SpringWeb.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiRespone<?>> ResourceNotFound(ResourceNotFoundException exception)
    {
        ApiError apiError = ApiError.builder().status(HttpStatus.NOT_FOUND).message(exception.getMessage()).build();
        return buildErrorResponseEntity(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiRespone<?>> InternalServerError(Exception exception)
    {
        ApiError apiError = ApiError.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).message(exception.getMessage()).build();
        return buildErrorResponseEntity(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiRespone<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception)
    {
        List<String> errors = exception.getBindingResult().getAllErrors().stream().map(error->error.getDefaultMessage()).collect(Collectors.toList());

        ApiError apiError = ApiError.builder().status(HttpStatus.BAD_REQUEST).message("Input Validation Failed").subErrors(errors).build();
        return buildErrorResponseEntity(apiError);
    }

    private ResponseEntity<ApiRespone<?>> buildErrorResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(new ApiRespone(apiError), apiError.getStatus());
    }
}

package com.filipe.rabbitmq.exceptionhandler;

import java.net.BindException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class ExceptionControllerHandler {
	private static final String DESCRIPTION = "description";
	
    @ExceptionHandler({BindException.class, HttpMessageNotReadableException.class,
    	IllegalArgumentException.class, MethodArgumentTypeMismatchException.class,
    	})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private Object handleIllegalArgumentException(Exception ex, HttpServletRequest request) {
    	return mountError(ex);
    }
    
    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private Object notFound(Exception ex, HttpServletRequest request) {
    	return mountError(ex);
    }
    
    @ExceptionHandler(value = InternalError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private Object serverError(Exception ex, HttpServletRequest request) {
    	return mountError(ex);
    }

    private HashMap<Object, Object> mountError(Exception e) {
        var error = new HashMap<>();
        error.put(DESCRIPTION, e.getMessage());
        return error;
    }
}

package com.codevergence.demo.masterdata.exception.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

@ControllerAdvice
public class CustomGlobalEmployeeExceptionHandler extends ResponseEntityExceptionHandler
{
    private static final List<String> EXPOSABLE_STRING = asList("timestamp", "status", "error", "message", "path");

    @ExceptionHandler(EmployeeNotFoundException.class)
    public void employeeHandlerNotFound(HttpServletResponse httpServletResponse) throws IOException
    {
        httpServletResponse.sendError(HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(BadRequestException.class)
    public void badRequestHandler(HttpServletResponse httpServletResponse) throws IOException
    {
        httpServletResponse.sendError(HttpStatus.BAD_REQUEST.value());
    }
}

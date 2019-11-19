package com.switchfully.teamteam.parkshark.infrastructure.exception;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;


@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    protected void idNotFound(NotFoundException exception, HttpServletResponse response)
            throws IOException {
        response.sendError(BAD_REQUEST.value(), exception.getMessage());
    }

}

package com.switchfully.teamteam.parkshark.infrastructure.apiExceptions;

import org.springframework.http.HttpStatus;

public class ApiException {
    private final String messege;

    private final HttpStatus httpStatus;

    public ApiException(String message, HttpStatus httpStatus) {
        this.messege = message;

        this.httpStatus = httpStatus;
    }

    public String getMessege() {
        return messege;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}

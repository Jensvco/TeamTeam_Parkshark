package com.switchfully.teamteam.parkshark.infrastructure.exception;

public class NotCreatedException extends RuntimeException {
    public NotCreatedException(){super("Not created, JSON is not in the correct format and/or missing input for non nullable fields.");}
}

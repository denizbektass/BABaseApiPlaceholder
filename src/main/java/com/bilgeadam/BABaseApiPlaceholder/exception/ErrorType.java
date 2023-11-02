package com.bilgeadam.BABaseApiPlaceholder.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorType {

    INTERNAL_ERROR_SERVER(5100, "Sunucu Hatası", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(4100, "Parametre hatası", HttpStatus.BAD_REQUEST),
//        BRANCH EXCEPTIONS
    BRANCH_NOT_FOUND(6000, "Sube bulunamamistir.", HttpStatus.BAD_REQUEST);


    private int code;
    private String message;
    private HttpStatus status;
}

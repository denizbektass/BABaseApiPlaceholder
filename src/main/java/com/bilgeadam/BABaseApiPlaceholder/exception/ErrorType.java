package com.bilgeadam.BABaseApiPlaceholder.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorType {

    INTERNAL_ERROR_SERVER(5100, "Sunucu Hatası", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(4100, "Parametre hatası", HttpStatus.BAD_REQUEST),
    TRAINER_NOT_FOUND(7000,"Girilen kritere uygun egitmen bulunamadi!",HttpStatus.NOT_FOUND),
    STUDENT_NOT_FOUND(8000,"Girilen kritere uygun öğrenci bulunamadi!",HttpStatus.NOT_FOUND),
    COURSE_NOT_FOUND(9000,"Girilen kritere uygun kurs bulunamadi!",HttpStatus.NOT_FOUND),
    TRAINER_ROLE_NOT_FOUND(7001,"Aranan turde egitmen rolu bulunamadi!",HttpStatus.NOT_FOUND),
    BRANCH_NOT_FOUND(6000, "Sube bulunamamistir.", HttpStatus.BAD_REQUEST),
    COURSEGROUP_NOT_FOUND(9000, "Kurs bulunamamistir.", HttpStatus.NOT_FOUND);



    private int code;
    private String message;
    private HttpStatus status;
}

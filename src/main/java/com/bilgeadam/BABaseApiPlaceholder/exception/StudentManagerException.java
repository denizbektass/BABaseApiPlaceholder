package com.bilgeadam.BABaseApiPlaceholder.exception;

import lombok.Getter;

@Getter
public class StudentManagerException extends RuntimeException{
    private final ErrorType errorType;

    public StudentManagerException(ErrorType errorType, String customMessage){
        super(customMessage);
        this.errorType=errorType;
    }
    public StudentManagerException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType=errorType;
    }

}

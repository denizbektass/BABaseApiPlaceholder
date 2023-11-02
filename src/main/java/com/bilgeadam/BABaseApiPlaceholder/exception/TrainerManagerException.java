package com.bilgeadam.BABaseApiPlaceholder.exception;

import lombok.Getter;

@Getter
public class TrainerManagerException extends RuntimeException{
    private final ErrorType errorType;

    public TrainerManagerException(ErrorType errorType, String customMessage){
        super(customMessage);
        this.errorType=errorType;
    }
    public TrainerManagerException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType=errorType;
    }

}

package com.bilgeadam.BABaseApiPlaceholder.exception;

import lombok.Getter;

@Getter
public class FakeBaseApiManagerException extends RuntimeException{
    private final ErrorType errorType;

    public FakeBaseApiManagerException(ErrorType errorType, String customMessage){
        super(customMessage);
        this.errorType=errorType;
    }
    public FakeBaseApiManagerException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType=errorType;
    }

}

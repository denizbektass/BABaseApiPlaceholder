package com.bilgeadam.BABaseApiPlaceholder.exception;

import lombok.Getter;

@Getter
public class CourseManagerException extends RuntimeException {
    private final ErrorType errorType;

    public CourseManagerException(ErrorType errorType, String customMessage){
        super(customMessage);
        this.errorType=errorType;
    }
    public CourseManagerException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType=errorType;
    }
}

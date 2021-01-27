package com.mohamedghareeb.springboot.cruddemo.exception;

public class EmployeeExceptionThrower extends RuntimeException {

    public EmployeeExceptionThrower() {
        super();
    }

    public EmployeeExceptionThrower(String message) {
        super(message);
    }

    public EmployeeExceptionThrower(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeExceptionThrower(Throwable cause) {
        super(cause);
    }

    protected EmployeeExceptionThrower(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

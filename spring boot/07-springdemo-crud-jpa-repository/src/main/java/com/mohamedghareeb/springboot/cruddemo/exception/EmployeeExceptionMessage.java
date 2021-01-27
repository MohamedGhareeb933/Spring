package com.mohamedghareeb.springboot.cruddemo.exception;

public class EmployeeExceptionMessage {

    private String message;

    private int status;

    private long time;

    public EmployeeExceptionMessage() {
    }

    public EmployeeExceptionMessage(String message, int status, long time) {
        this.message = message;
        this.status = status;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}

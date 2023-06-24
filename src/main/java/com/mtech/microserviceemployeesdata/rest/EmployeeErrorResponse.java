package com.mtech.microserviceemployeesdata.rest;

public class EmployeeErrorResponse {
    private int status;
    private String message;
    private Long timestamp;

    public EmployeeErrorResponse() {

    }

    public EmployeeErrorResponse(int status, String message, Long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "EmployeeErrorResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

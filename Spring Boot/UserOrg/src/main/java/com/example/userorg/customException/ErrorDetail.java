package com.example.userorg.customException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@Setter
public class ErrorDetail {
    private Date timestamp;
    private String message;
    private String details;
    private HttpStatus status;

    public ErrorDetail(String message, String details, HttpStatus status) {
        super();
        this.message = message;
        this.details = details;
        this.status = status;
    }

    public ErrorDetail(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}

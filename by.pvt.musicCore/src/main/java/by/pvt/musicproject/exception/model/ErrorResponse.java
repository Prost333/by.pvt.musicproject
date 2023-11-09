package by.pvt.musicproject.exception.model;

import lombok.Data;

@Data
public class ErrorResponse {
    private String message;
    private String code;
}

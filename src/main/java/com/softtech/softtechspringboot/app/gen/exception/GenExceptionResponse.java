package com.softtech.softtechspringboot.app.gen.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;
@Data  //getter - setter ile uğraşmamak için
@AllArgsConstructor
public class GenExceptionResponse {

    private Date errorDate;
    private String message;
    private String detail;
}

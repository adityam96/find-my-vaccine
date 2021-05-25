package com.fmv.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DaoException extends RuntimeException {
    private Integer statusCode;
    private String message;
}

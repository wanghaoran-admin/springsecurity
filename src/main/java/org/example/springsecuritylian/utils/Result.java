package org.example.springsecuritylian.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result {
    private Integer code;
    private Object data;
    private String msg;
}


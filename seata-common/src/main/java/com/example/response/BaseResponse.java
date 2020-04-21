package com.example.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author guanyf
 */

@Data
public class BaseResponse  implements Serializable {

    private String code ;
    private String message;
}

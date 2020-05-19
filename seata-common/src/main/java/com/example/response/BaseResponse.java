package com.example.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author boomboompow
 * @date 2020/5/19 2:00 PM
 */

@Data
public class BaseResponse  implements Serializable {

    private String code ;
    private String message;
}

package com.example.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author guanyf
 */
@Getter
@AllArgsConstructor
public enum ResponseCodeEnum implements IError{


    SUCCESS("200", "请求成功"),
    FAIL("500", "请求失败");

    private String code;
    private String message;

    @Override
    public String getErrorCode() {
        return code;
    }

    @Override
    public String getErrorMsg() {
        return message;
    }
}

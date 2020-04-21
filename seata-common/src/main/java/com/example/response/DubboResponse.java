package com.example.response;

import com.example.enums.IError;
import com.example.enums.ResponseCodeEnum;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

/**
 * @author guanyf
 */
@Data
public class DubboResponse<T> extends BaseResponse {


    private Boolean success;
    private T data;

    public boolean isSuccess() {
        return success != null && success;
    }

    public static  <T> DubboResponse<T> success(T data) {

        return base("200", null, true, data);
    }

    public static <T> DubboResponse<T> fail(String code, String msg) {

        return base(code, msg, false, null);
    }

    public static <T> DubboResponse<T> fail(IError iError) {
        return base(iError.getErrorCode(), iError.getErrorMsg(), false, null);
    }

    private static <T> DubboResponse<T> base(String code, String msg, boolean success, T data){
        DubboResponse response = new DubboResponse();
        response.setCode(code);
        response.setSuccess(success);
        response.setMessage(msg);
        response.setData(success ? data :null);
        return  response;
    }

}

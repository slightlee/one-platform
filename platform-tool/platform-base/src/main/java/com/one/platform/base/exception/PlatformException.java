package com.one.platform.base.exception;

import com.one.platform.base.enums.ResultCodeEnum;
import lombok.Data;

/**
 * 自定义处理异常
 */
@Data
public class PlatformException extends RuntimeException {

    private int code;

    private String msg;

    public PlatformException() {
        this.code = ResultCodeEnum.INTERNAL_SERVER_ERROR.code;
        this.msg = ResultCodeEnum.INTERNAL_SERVER_ERROR.msg;
    }

    public PlatformException(String message) {
        this.code = ResultCodeEnum.INTERNAL_SERVER_ERROR.code;
        this.msg = message;
    }

    public PlatformException(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMsg();
    }

    public PlatformException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
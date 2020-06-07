package zrx.springbootinterceptor.exception;

import zrx.springbootinterceptor.result.ErrorCode;

import java.util.Map;

public class CustomException extends BaseException {
    public CustomException(ErrorCode error, Map<String, Object> data) {
        super(ErrorCode.RESOURCE_NOT_FOUND, data);
    }
}

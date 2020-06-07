package zrx.springbootinterceptor.exception;

import zrx.springbootinterceptor.result.ErrorCode;

import java.util.Map;

/**
 * 自定义异常
 */
public class ResourceNotFountException extends BaseException {
    public ResourceNotFountException(Map<String, Object> data) {
        super(ErrorCode.RESOURCE_NOT_FOUND, data);
    }
}

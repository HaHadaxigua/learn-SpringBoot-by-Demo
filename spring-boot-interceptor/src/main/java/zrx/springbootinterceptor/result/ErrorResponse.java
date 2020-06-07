package zrx.springbootinterceptor.result;

import lombok.Data;
import org.springframework.util.ObjectUtils;
import zrx.springbootinterceptor.exception.BaseException;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * 这个类作为异常信息返回给客户端，里面包括了当出现异常时我们想要返回给客户端的所有信息
 */
@Data
public class ErrorResponse {
    private int code;
    private int status;
    private String message;
    private String path;
    private Instant timestamp;
    private HashMap<String, Object> data = new HashMap<String, Object>();

    public ErrorResponse() {
    }

    public ErrorResponse(BaseException ex, String path) {
        this(ex.getError().getCode(), ex.getError().getStatus().value(), ex.getError().getMessage(), path, ex.getData());
    }

    public ErrorResponse(int code, int status, String message, String path, Map<String, Object> data) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.path = path;
        this.timestamp = Instant.now();
        if (!ObjectUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
    }

}

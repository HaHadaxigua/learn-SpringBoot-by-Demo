package zrx.springbootinterceptor.result;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
public class Response {
    private int code;
    private int status;
    private String message;
    private Instant timestamp;
    private Object data;

    public Response(int code, int status, String message, Instant timestamp, Object data) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.data = data;
    }
}

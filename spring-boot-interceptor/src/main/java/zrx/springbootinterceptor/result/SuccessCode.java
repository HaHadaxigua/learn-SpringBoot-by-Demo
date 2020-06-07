package zrx.springbootinterceptor.result;

import org.springframework.http.HttpStatus;

public enum SuccessCode {
    SUCCESS(200, HttpStatus.OK, "it's ok");
    private final int code;
    private final HttpStatus status;
    private final String message;

    SuccessCode(int code, HttpStatus status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }
}

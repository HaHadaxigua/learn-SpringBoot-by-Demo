package zrx.springbootinterceptor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zrx.springbootinterceptor.exception.BaseException;
import zrx.springbootinterceptor.exception.CustomException;
import zrx.springbootinterceptor.result.ErrorCode;
import zrx.springbootinterceptor.result.ErrorResponse;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class AuthController {
    @RequestMapping("/authA")
    public ErrorCode authA(HttpServletRequest request) {
        return ErrorCode.RESOURCE_NOT_FOUND;
    }

    @RequestMapping("/authB")
    public ErrorCode authB() {
        return ErrorCode.HAVE_NO_AUTHORITY;
    }
}

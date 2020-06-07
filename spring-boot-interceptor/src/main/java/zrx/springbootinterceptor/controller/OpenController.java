package zrx.springbootinterceptor.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zrx.springbootinterceptor.result.ErrorCode;
import zrx.springbootinterceptor.result.SuccessCode;

@RestController
@RequestMapping("/api")
public class OpenController {
    @RequestMapping("/openA")
    public SuccessCode testA() {
        return SuccessCode.SUCCESS;
    }

    @RequestMapping("/openB")
    public SuccessCode testB() {
        return SuccessCode.SUCCESS;
    }
}

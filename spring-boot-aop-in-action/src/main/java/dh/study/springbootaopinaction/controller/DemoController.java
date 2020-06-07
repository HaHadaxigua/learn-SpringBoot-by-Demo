package dh.study.springbootaopinaction.controller;

import dh.study.springbootaopinaction.reqhttp.AuthChecker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @RequestMapping(path = "/aop/http/alive")
    public String alive() {
        return "服务一切正常";
    }

    @AuthChecker
    @RequestMapping(path = "/aop/http/user_info")
    public String callSomeInterface() {
        return "调用了user_info接口";
    }
}

package zrx.springbootinterceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zrx.springbootinterceptor.result.Response;

import java.time.Instant;

@RestController
@RequestMapping("/filter")
public class TestFilterController {
    @GetMapping("/a")
    public Response testA() {
        Response response = new Response(666, 200, "测试testA()", Instant.now(), "data is empty");
        return response;
    }

    @GetMapping("/b")
    public Response testB() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Response response = new Response(666, 200, "测试testB()", Instant.now(), "data is empty");
        return response;
    }
}

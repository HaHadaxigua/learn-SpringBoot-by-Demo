package zrx.springbootinterceptor.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zrx.springbootinterceptor.entity.Person;
import zrx.springbootinterceptor.exception.ResourceNotFountException;

import java.util.HashMap;
import java.util.Map;


@RequestMapping("/api")
@RestController
public class ExceptionController {
    @GetMapping("/ ")
    public void throwException() {
        throw new IllegalArgumentException();
    }

    @GetMapping("/resourceNotFoundException")
    public void throwException2() {
        Person p = new Person(1, "zrx");
        Map map = new HashMap();
        map.put(p, "resource not find");
        throw new ResourceNotFountException(map);
    }

}

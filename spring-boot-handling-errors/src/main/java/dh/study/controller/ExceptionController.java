package dh.study.controller;

import dh.study.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ExceptionController {
    @GetMapping("/illegalArgumentException")
    public void throwException(){
        throw new IllegalArgumentException();
    }

    public void throwException2(){
        throw new ResourceNotFoundException();
    }
}

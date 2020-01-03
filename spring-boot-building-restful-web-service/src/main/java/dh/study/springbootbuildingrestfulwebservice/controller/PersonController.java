package dh.study.springbootbuildingrestfulwebservice.controller;

import dh.study.springbootbuildingrestfulwebservice.dto.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(path = "person")
public class PersonController {
    private String template = "hello, i'm %s";
    private AtomicLong counter = new AtomicLong();
    private ArrayList<Person> list = new ArrayList<>();

    @GetMapping(path = "/all")
    private ArrayList<Person> showAll(){
        return list;
    }

    @PostMapping(path = "/add")
    private ArrayList<Person> addPerson(@RequestParam(name = "name") String name){
        list.add(new Person(counter.incrementAndGet(), String.format(template, name)));
        return list;
    }
}

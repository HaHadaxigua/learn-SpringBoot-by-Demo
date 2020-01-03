package dh.study.springbootbuildingrestfulwebservice.controller;

import dh.study.springbootbuildingrestfulwebservice.dto.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/student")
public class StudentController {
    private ArrayList<Student> list = new ArrayList<>();
    private static final String template = "hello, i'm ";

    /**
     * 用于测试，实际上不要将get和post请求何在一起
     * @param student
     * @return
     */
    @PostMapping("/add")
    private void addStudent(@RequestBody Student student){
        list.add(student);
    }

    @GetMapping("/all")
    private ResponseEntity<ArrayList<Student>> findAll(){
        return ResponseEntity.ok(list);
    }
}

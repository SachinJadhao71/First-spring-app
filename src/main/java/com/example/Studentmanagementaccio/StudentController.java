package com.example.Studentmanagementaccio;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    Map<Integer, Student> studentsDb = new HashMap<>(); // db - key - admnNo

    @GetMapping("/get_info")
    public Student getStudent(@RequestParam("id") int admnNo){
        return studentsDb.get(admnNo);
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        studentsDb.put(student.getAddmNo(),student);
        return "Student added successfully";
    }

    @GetMapping("/get/{id}/{message}")
    public Student getStudentByPathVariable(@PathVariable("id") int admnNo, @PathVariable("message") String message){
        return studentsDb.get(admnNo);
    }
}

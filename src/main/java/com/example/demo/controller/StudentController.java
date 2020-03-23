package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import java.util.*;
import java.util.List;
@RestController

//@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /*@PostMapping("/insert")
    public ResponseEntity<Object> insertinfo( @RequestParam("id")String id,
                                              @RequestParam("name")String name,
                                              @RequestParam("subject")String subject,
                                              @RequestParam("result")Integer result)
    {
        Student student = new Student();
        student.setid(id);
        student.setname(name);
        student.setsubject(subject);
        student.setresult(result);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);

    }*/
    @PostMapping("/insert")
    public ResponseEntity<Object> insertinfo(Student student) {
        studentService.updateresult(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/get/{name}")
    public ResponseEntity<List<Student>> selectone(@PathVariable("name") String name) {
        List<Student> students=studentService.selectone(name);
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Object> deleteone(@PathVariable("name") String name) {
        studentService.deleteone(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> updateresult(Student student) {
        studentService.updateresult(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @RequestMapping(value="/get/{name}",method=RequestMethod.GET)
//    public Map<List, Object> selectone(@PathVariable("name")String name){
//        Map<List, Object> modelMap = new HashMap<List, Object>();
//        studentService.selectone(name);
//    }


}

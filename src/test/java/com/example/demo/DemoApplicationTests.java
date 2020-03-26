package com.example.demo;

import com.example.demo.bean.Student;
import com.example.demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Test
    void contextLoads() {}

    @Autowired
    private StudentService studentService;

    @Test
    void insertinfotext() {
        Student student=new Student();
        student.setsubject("english");
        student.setresult(10);
        student.setname("lxd");
        student.setid("07");
        studentService.insertinfo(student);
    }
    @Test
    void selectonetext() {
        Student student = studentService.selectone("lxd");
        System.out.println(student.toString());
    }

    @Test
    void deleteonetext() {
        studentService.deleteone("wanhui");
    }
//
    @Test
    void updateresulttext() {
        Student student=new Student();
        student.setsubject("english");
        student.setresult(77);
        student.setname("lxd");
        student.setid("07");
        studentService.updateresult(student);
    }



}

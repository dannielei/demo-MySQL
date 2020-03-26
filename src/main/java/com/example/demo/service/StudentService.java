package com.example.demo.service;

import com.example.demo.bean.Student;
import java.util.List;
public interface StudentService {

    //    增加
    void insertinfo(Student student);
    //    按name查找
    Student selectone(String name);
    //    删除name
    void deleteone(String name);
    //    修改result
    void updateresult(Student student);
}

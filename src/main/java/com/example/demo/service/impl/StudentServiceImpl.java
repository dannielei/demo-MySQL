package com.example.demo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.bean.Student;
import com.example.demo.dao.StudentDao;
import com.example.demo.service.StudentService;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired	private StudentDao studentDao;


    @Override
    public void insertinfo(Student student){
        studentDao.insertinfo(student);
    }

    @Override
    public Student selectone(String name){
        return studentDao.selectone(name);
    }

    @Override
    public void deleteone(String name){
        studentDao.deleteone(name);
    }

    @Override
    public void updateresult(Student student){
        studentDao.updateresult(student);
    }

}

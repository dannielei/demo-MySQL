package com.example.demo.dao;

import com.example.demo.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface StudentDao {

    //    增加
    void insertinfo(Student student);
    //    按name查找
    List<Student> selectone(String name);
    //    删除name
    void deleteone(String name);
    //    修改result
    void updateresult(Student student);
}

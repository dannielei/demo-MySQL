package com.example.demo.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import com.example.demo.bean.Student;
import com.example.demo.dao.StudentDao;






@Component
public class StudentRedisUtil {
    private static final String PERSON_TABLE_NAME = "person";
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private StudentDao studentDao;


    /**
     * 向redis缓冲用户信息
     *
     * @param student
     */
    public void insertStudentToRedis(Student student) {
        redisTemplate.opsForHash().put(PERSON_TABLE_NAME, String.valueOf(student.getid()), student);
        if (studentDao.selectone(student.getid()) == null) {
            studentDao.insertinfo(student);
        }

    }


    /**
     * 向redis查找用户，redis没有则向数据库查找并缓冲到redis中
     *
     * @param name
     * @return
     */
    public Student getStudentFromRedisById(String name) {
        Boolean isHasKey = redisTemplate.opsForHash().hasKey(PERSON_TABLE_NAME, String.valueOf(name));
        Student student;
        if (isHasKey == true) {
            student = (Student) redisTemplate.opsForHash().get(PERSON_TABLE_NAME, String.valueOf(name));
        } else {
            student = studentDao.selectone(name);
            insertStudentToRedis(student);
        }
        return student;
    }

    /**
     * redis有用户信息则更新并且更新数据库用户信息
     *
     * @param student
     */
    public void updateStudentToRedis(Student student) {
        String name = student.getid();
        if (studentDao.selectone(name) != null) {
            studentDao.updateresult(student);
            insertStudentToRedis(student);
        }
    }

    /**
     * redis有用户信息则删除，无论与否都要删除数据库用户信息
     *
     * @param name
     */
    public void deleteStudentByIdFromRedis(String name) {
        Boolean isHasKey = redisTemplate.opsForHash().hasKey(PERSON_TABLE_NAME, String.valueOf(name));
        if (isHasKey == true) {
            redisTemplate.opsForHash().delete("person", name);
            studentDao.deleteone(name);
        }
        if (studentDao.selectone(name) != null) {
            studentDao.deleteone(name);
        }
    }


























}

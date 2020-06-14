package com.service;

import com.bean.Course;
import com.bean.Student;
import com.bean.Teacher;
import com.dao.UserDao;

import java.util.List;

public class GetAllMessage {
    public static List<Student> getAllStudent(){
        return UserDao.getAllStudent();
    }
    public static List<Teacher> getAllTeacher(){
        return UserDao.getAllTeacher();
    }
    public static List<Course> getAllCourse(){
        return UserDao.getAllCourse();
    }
}

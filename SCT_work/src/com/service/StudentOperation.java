package com.service;

import com.bean.Student;
import com.dao.StudentDao;

import java.util.List;

public class StudentOperation {
    //通过学号获取学生信息
    public static Student getStudentBySid(int sid){
        return StudentDao.getStudentBySid(sid);
    }

    //获取学生的选课信息（课程编号，课程名以及任课教师）
    public static List<Object[]> findCourseByStudent(Student s){
        return StudentDao.findCourseByStudent(s);
    }

    //获取学生未选的课程信息
    public static List<Object[]> findNotCourseByStudent(Student s){
        return StudentDao.findNotCourseByStudent(s);
    }

    //学生添加课程信息
    public static boolean addCourseByCid(Student s,int cid){
        return StudentDao.addCourseByCid(s,cid);
    }

    //通过学生和课程编号删除课程
    public static boolean deleteCourseByStudent(Student s,int cid){
        return StudentDao.deleteCourseByStudent(s,cid);
    }
}

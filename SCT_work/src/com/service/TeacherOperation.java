package com.service;

import com.bean.Course;
import com.bean.Student;
import com.bean.Teacher;
import com.dao.TeacherDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherOperation {
    //通过工号获取教师
    public static Teacher getTeacherByTid(int tid){
        return TeacherDao.getTeacherByTid(tid);
    }

    //通过教师获取所教课程
    public static List<Course> getAllCourseByTeacher(Teacher t){
        return TeacherDao.getAllCourseByTeacher(t);
    }

    //通过课程获取学生信息
    public static List<Student> getAllStudentByCourse(Course c){
        return TeacherDao.getAllStudentByCourse(c);
    }

    //获取某教师所教所有课程及选择该课程的所有学生
    public static Map<Course,List<Student>> getCoursesAndStudents(Teacher t){
        Map<Course,List<Student>> map = new HashMap<>();
        List<Course> courses = getAllCourseByTeacher(t);
        if(courses!=null) {
            for (Course course : courses) {
                List<Student> studentList = getAllStudentByCourse(course);
                map.put(course, studentList);
            }
        }else{
            System.out.println("错误!!!!");
        }
        return map;
    }

}

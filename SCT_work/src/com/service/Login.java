package com.service;

import com.bean.Student;
import com.bean.Teacher;
import com.bean.User;
import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.dao.UserDao;

public class Login {
    //判断学生登陆
    public static boolean studentLogin(int sid,String password){
        Student student = StudentDao.getStudent(sid, password);
        if(student!=null){
            return true;
        }else {
            return false;
        }
    }
    //判断教师登陆
    public static boolean teacherLogin(int tid,String password){
        Teacher teacher = TeacherDao.getTeacher(tid,password);
        if(teacher!=null){
            return true;
        }else {
            return false;
        }
    }
    //判断管理员登陆
    public static boolean userLogin(String username,String password){
        User user = UserDao.getUser(username, password);
        if(user!=null){
            return true;
        }else {
            return false;
        }
    }
}

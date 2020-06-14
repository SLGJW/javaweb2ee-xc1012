package com.service;

import com.bean.Student;
import com.dao.UserDao;

public class UserOperation {
    //管理员添加学生
    public static boolean userAddStudent(Student s){
        return UserDao.userAddStudent(s);
    }

    //管理员修改学生信息
    public static boolean userUpdateStudent(Student s,int oldsid){
        return UserDao.userUpdateStudent(s, oldsid);
    }

    //通过学号获取学生信息
    public static Student getStudentBySid(int sid){
        return UserDao.getStudntBySid(sid);
    }

    //管理员删除学生信息
    public static boolean userDeleteStudent(Student s){
        return UserDao.userDeleteStudent(s);
    }
}

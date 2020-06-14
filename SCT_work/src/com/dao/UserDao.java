package com.dao;

import com.bean.Course;
import com.bean.Student;
import com.bean.Teacher;
import com.bean.User;
import com.utils.MyUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    private static QueryRunner qr = MyUtils.getDataBase();
    //根据学号和密码查询学生信息
    public static User getUser(String username,String password){
        String sql = "select * from user where username=? and password=?";
        try {
            User user = qr.query(sql,new BeanHandler<>(User.class),username,password);
            if(user!=null){
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取所有学生信息
    public static List<Student> getAllStudent(){
        String sql = "select * from student";
        List<Student> list = null;
        try {
            list = qr.query(sql,new BeanListHandler<>(Student.class));
            if(list!=null){
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取所有教师信息
    public static List<Teacher> getAllTeacher(){
        String sql = "select * from teacher";
        List<Teacher> list = null;
        try {
            list = qr.query(sql,new BeanListHandler<>(Teacher.class));
            if(list!=null){
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取所有课程信息
    public static List<Course> getAllCourse(){
        String sql = "select * from course";
        List<Course> list = null;
        try {
            list = qr.query(sql,new BeanListHandler<>(Course.class));
            if(list!=null){
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过教师学号获取教师姓名
    public static String getTeacherNameBytid(int tid){
        String sql = "select tname from teacher where tid=?";
        try {
            Object obj = qr.query(sql, new ScalarHandler(), tid);
            if(obj!=null) {
                String tname = obj.toString();
                return tname;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //学生信息的添加
    public static boolean userAddStudent(Student student){
        String sql = "insert into student values(?,?,?)";
        try {
            int result = qr.update(sql,student.getSid(),student.getSname(),student.getPassword());
            if(result>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //通过学号获取学生信息
    public static Student getStudntBySid(int sid){
        String sql = "select * from student where sid=?";
        try {
            Student student = qr.query(sql, new BeanHandler<>(Student.class),sid);
            if(student!=null){
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //学生信息的修改
    public static boolean userUpdateStudent(Student student,int oldsid){
        String sql = "update student set sid=?,sname=?,password=? where sid=?";
        try {
            int result = qr.update(sql,student.getSid(),student.getSname(),student.getPassword(),oldsid);
            if(result>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //学生信息的删除
    public static boolean userDeleteStudent(Student student){
        String sql = "delete from student where sid=?";
        try {
            int result = qr.update(sql,student.getSid());
            if(result>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

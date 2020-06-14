package com.dao;

import com.bean.Student;
import com.utils.MyUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.List;

public class StudentDao {
    private static QueryRunner qr = MyUtils.getDataBase();
    //根据学号和密码查询学生信息
    public static Student getStudent(int sid,String password){
        String sql = "select * from student where sid=? and password=?";
        try {
            Student student = qr.query(sql,new BeanHandler<>(Student.class),sid,password);
            if(student!=null){
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过学号获取学生
    public static Student getStudentBySid(int sid){
        String sql = "select * from student where sid=?";
        try {
            Student student = qr.query(sql,new BeanHandler<>(Student.class),sid);
            if(student!=null){
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取学生的选课信息（课程编号，课程名以及任课教师）
    public static List<Object[]> findCourseByStudent(Student student){
        String sql = "select c.cid,c.cname,t.tname from course as c inner join teacher as t on c.course_teacher = t.tid where tid in(select course_teacher from course where c.cid in(select cid from student_course where sid=?))";
        List<Object[]> list = null;
        try {
            list = qr.query(sql, new ArrayListHandler(),student.getSid());
            if(list!=null) {
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取学生未选的课程信息
    public static List<Object[]> findNotCourseByStudent(Student student){
        String sql = "select c.cid,c.cname,t.tname from course as c inner join teacher as t on c.course_teacher = t.tid where tid in(select course_teacher from course where c.cid not in(select cid from student_course where sid=?))";
        List<Object[]> list = null;
        try {
            list = qr.query(sql, new ArrayListHandler(),student.getSid());
            if(list!=null) {
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过课程编号添加课程
    public static boolean addCourseByCid(Student student,int cid){
        String sql = "insert into student_course values(?,?)";
        try {
            int resault = qr.update(sql,student.getSid(),cid);
            if(resault>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //通过学生和课程编号删除课程
    public static boolean deleteCourseByStudent(Student student,int cid){
        String sql = "delete from student_course where sid=? and cid=?";
        try {
            int resault = qr.update(sql,student.getSid(),cid);
            if(resault>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

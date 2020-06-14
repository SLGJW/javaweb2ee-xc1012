package com.dao;

import com.bean.Course;
import com.bean.Student;
import com.bean.Teacher;
import com.utils.MyUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class TeacherDao {
    private static QueryRunner qr = MyUtils.getDataBase();
    //根据学号和密码查询教师信息
    public static Teacher getTeacher(int tid,String password){
        String sql = "select * from teacher where tid=? and password=?";
        try {
            Teacher teacher = qr.query(sql,new BeanHandler<>(Teacher.class),tid,password);
            if(teacher!=null){
                return teacher;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Teacher getTeacherByTid(int tid){
        String sql = "select * from teacher where tid=?";
        try {
            Teacher teacher = qr.query(sql, new BeanHandler<>(Teacher.class), tid);
            if(teacher!=null){
                return teacher;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //查询所教所有课程信息
    public static List<Course> getAllCourseByTeacher(Teacher teacher){
        String sql = "select * from course where course_teacher=?";
        List<Course> list = null;
        try {
            list = qr.query(sql, new BeanListHandler<>(Course.class), teacher.getTid());
            if(list!=null){
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //查询选择某门课程的所有学生信息
    public static List<Student> getAllStudentByCourse(Course course){
        String sql = "select s.* from student s,student_course s_c where s_c.cid=? and s.sid=s_c.sid";
        List<Student> list = null;
        try {
            list = qr.query(sql, new BeanListHandler<>(Student.class), course.getCid());
            if(list!=null){
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

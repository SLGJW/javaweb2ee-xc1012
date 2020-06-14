package com.servlet;

import com.bean.Course;
import com.bean.Student;
import com.bean.Teacher;
import com.service.TeacherOperation;
import com.sun.xml.internal.ws.client.RequestContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.lang.Integer.parseInt;

@WebServlet("/teacherServlet")
public class TeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int tid = parseInt(request.getAttribute("tid").toString());
        Teacher teacher = TeacherOperation.getTeacherByTid(tid);
        Map<Course,List<Student>> map = TeacherOperation.getCoursesAndStudents(teacher);
        if(map!=null){
            request.setAttribute("t",teacher);
            request.setAttribute("map",map);
            request.getRequestDispatcher("/teacher.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

package com.servlet;

import com.bean.Student;
import com.service.StudentOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sid = parseInt(request.getAttribute("sid").toString());
        Student student = StudentOperation.getStudentBySid(sid);
        List<Object[]> list = StudentOperation.findCourseByStudent(student);
        if (list != null) {
            request.setAttribute("s",student);
            request.setAttribute("list", list);
            request.getRequestDispatcher("/student.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

package com.servlet;

import com.bean.Student;
import com.service.StudentOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet("/studentDeleteCourse")
public class StudentDeleteCourse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int cid = parseInt(request.getParameter("cid"));
        int sid = parseInt(request.getParameter("sid"));
        Student student = StudentOperation.getStudentBySid(sid);
        boolean flag = StudentOperation.deleteCourseByStudent(student, cid);
        if(flag){
            request.setAttribute("sid", sid);
            request.getRequestDispatcher("/studentServlet").forward(request, response);
        }else{
            request.setAttribute("message", "添加失败！");
            request.getRequestDispatcher("/studentResult.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

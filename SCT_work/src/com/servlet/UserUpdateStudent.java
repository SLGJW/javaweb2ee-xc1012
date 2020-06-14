package com.servlet;

import com.bean.Student;
import com.service.UserOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet("/userUpdateStudent")
public class UserUpdateStudent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int oldsid = parseInt(request.getParameter("oldsid"));
        int sid = parseInt(request.getParameter("sid"));
        String sname = request.getParameter("sname");
        String password = request.getParameter("password");
        Student student = new Student(sid,sname,password);
        boolean flag = UserOperation.userUpdateStudent(student, oldsid);
        if(flag){
            request.setAttribute("message", "修改成功！");
        }else{
            request.setAttribute("message", "修改失败！");
        }
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

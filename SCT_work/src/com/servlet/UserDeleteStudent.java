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

@WebServlet("/userDeleteStudent")
public class UserDeleteStudent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sid = parseInt(request.getParameter("sid"));
        Student student = UserOperation.getStudentBySid(sid);
        boolean flag = UserOperation.userDeleteStudent(student);
        if(flag){
            request.setAttribute("message", "删除成功！");
        }else{
            request.setAttribute("message", "删除失败！");
        }
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

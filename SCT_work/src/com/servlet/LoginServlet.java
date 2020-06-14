package com.servlet;

import com.service.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String info = null;
        String identity = request.getParameter("identity");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(identity==null || identity.length()==0){
            info="请选择身份！";
        }else if(username==null || identity.length()==0){
            info="请输入登录名！";
        }else if(password==null || identity.length()==0){
            info="请输入口令！";
        }
        if(info==null){
            if("student".equals(identity)){
                int sid = parseInt(username);
                boolean flag = Login.studentLogin(sid,password);
                if(flag){
                    request.setAttribute("sid", sid);
                    request.getRequestDispatcher("/studentServlet").forward(request, response);
                }else{
                    request.setAttribute("info", "用户名或密码错误！");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
            }
            if("teacher".equals(identity)){
                int tid = parseInt(username);
                boolean flag = Login.teacherLogin(tid,password);
                if(flag){
                    request.setAttribute("tid", tid);
                    request.getRequestDispatcher("/teacherServlet").forward(request, response);
                }else{
                    request.setAttribute("info", "用户名或密码错误！");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
            }
            if("user".equals(identity)){
                boolean flag = Login.userLogin(username,password);
                if(flag){
                    response.sendRedirect(request.getContextPath()+"/user.jsp");
                }else{
                    request.setAttribute("info", "用户名或密码错误！");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
            }
        }else{
            request.setAttribute("info", info);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

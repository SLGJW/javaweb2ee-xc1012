<%@ page import="com.service.GetAllMessage" %>
<%@ page import="com.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bean.Teacher" %>
<%@ page import="com.bean.Course" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员界面</title>
</head>
<body>
<%
    List<Student> students = GetAllMessage.getAllStudent();
    List<Teacher> teachers = GetAllMessage.getAllTeacher();
    List<Course> courses = GetAllMessage.getAllCourse();
    request.setAttribute("studnts",students);
    request.setAttribute("teachers",teachers);
    request.setAttribute("courses",courses);
%>
<table align="center" width="400px" cellspacing="0px" border="1px" bgcolor="aqua">
    <caption>学生信息&nbsp;&nbsp;<a href="userAddStudent.jsp">添加学生</a></caption>
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>密码</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${studnts}" var="s">
        <tr>
            <td>${s.sid}</td>
            <td>${s.sname}</td>
            <td>${s.password}</td>
            <td>
                <a href="userUpdateStudent.jsp?sid=${s.sid}">修改</a> || <a href="${pageContext.request.contextPath}/userDeleteStudent?sid=${s.sid}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<hr>
<table align="center" width="400px" cellspacing="0px" border="1px" bgcolor="#32cd32">
    <caption>教师信息&nbsp;&nbsp;<a href="userAddTeacher.jsp">添加教师</a></caption>
    <tr>
        <th>工号</th>
        <th>姓名</th>
        <th>密码</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${teachers}" var="t">
        <tr>
            <td>${t.tid}</td>
            <td>${t.tname}</td>
            <td>${t.password}</td>
            <td>
                <a href="#">修改</a> || <a href="#">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<hr>
<table align="center" width="400px" cellspacing="0px" border="1px" bgcolor="yellow">
    <caption>课程信息&nbsp;&nbsp;<a href="userAddCourse.jsp">添加课程</a></caption>
    <tr>
        <th>课程编号</th>
        <th>课程名</th>
        <th>任课教师</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${courses}" var="c">
        <tr>
            <td>${c.cid}</td>
            <td>${c.cname}</td>
            <td>${c.tname}</td>
            <td>
                <a href="#">修改</a> || <a href="#">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

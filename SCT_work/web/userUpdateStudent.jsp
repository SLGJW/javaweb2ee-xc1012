<%@ page import="static java.lang.Integer.parseInt" %>
<%@ page import="com.service.UserOperation" %>
<%@ page import="com.bean.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息的修改</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    int oldsid = Integer.parseInt(request.getParameter("sid"));
    Student student = UserOperation.getStudentBySid(oldsid);
    pageContext.setAttribute("s",student);
%>
<form action="${pageContext.request.contextPath}/userUpdateStudent" method="post">
    学号：<input type="text" name="sid" value="${s.sid}"><br>
    <input type="hidden" name="oldsid" value="${s.sid}">
    姓名：<input type="text" name="sname" value="${s.sname}"><br>
    密码：<input type="text" name="password" value="${s.password}"><br>
    <input type="reset" value="重置"><input type="submit" value="修改">
</form>
</body>
</html>

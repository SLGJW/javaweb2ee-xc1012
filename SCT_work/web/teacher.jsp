<%@ page import="com.bean.Course" %>
<%@ page import="com.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>教师界面</title>
</head>
<body>
<h1>欢迎${requestScope.t.tname}!!!</h1>
您所教的所有课程为：<br>
<%  if(request.getAttribute("map")!=null){
    Map<Course,List<Student>> map = (Map<Course, List<Student>>)request.getAttribute("map");
    Set<Course> courses = map.keySet();
    for(Course course : courses){%>
        <p><h3><%=course.getCname()%>===</h3>
        选择<%=course.getCname()%>的学生有：<br>
        <%
            List<Student> students = map.get(course);
            for(Student student : students){%>
                <%=student.getSname()%><br>
            <%}%></p>
    <%}
}%>
</body>
</html>

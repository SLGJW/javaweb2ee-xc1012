<%@ page import="com.service.StudentOperation" %>
<%@ page import="com.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加选课</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    int sid = Integer.parseInt(request.getParameter("sid"));
    Student student = StudentOperation.getStudentBySid(sid);
    List<Object[]> notCourseByStudent = StudentOperation.findNotCourseByStudent(student);
    request.setAttribute("sid",sid);
    request.setAttribute("nc",notCourseByStudent);
%>
尚未选择的课程有：
<form method="get" action="${pageContext.request.contextPath}/studentAddCourse">
    <input type="hidden" name="sid" value="${requestScope.sid}">
    <select name="cid">
        <option disabled selected>课程编号---课程名---任课教师</option>
        <c:forEach items="${requestScope.nc}" var="objs">
            <option value="${objs[0]}">${objs[0]}--${objs[1]}--${objs[2]}</option>
        </c:forEach>
    </select>
    <input type="submit" value="添加">
</form>
</body>
</html>

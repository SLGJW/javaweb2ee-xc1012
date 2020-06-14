<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生界面</title>
</head>
<body>
<h1>你好！${requestScope.s.sname}同学</h1>
<table align="center" width="400px" cellspacing="0px" border="1px">
    <caption>您所选的课程信息&nbsp;&nbsp;<a href="studentAddCourse.jsp?sid=${requestScope.s.sid}">添加课程</a></caption>
    <tr>
        <th>课程编号</th>
        <th>课程名</th>
        <th>任课教师</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${requestScope.list}" var="objs">
        <tr>
            <td>${objs[0]}</td>
            <td>${objs[1]}</td>
            <td>${objs[2]}</td>
            <td>
                <a href="${pageContext.request.contextPath}/studentDeleteCourse?cid=${objs[0]}&sid=${requestScope.s.sid}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

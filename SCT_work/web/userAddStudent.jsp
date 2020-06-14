<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生信息</title>
</head>
<body>
<h1>学生信息的录入</h1>
<form action="${pageContext.request.contextPath}/userAddStudent" method="post">
    学号：<input name="sid" type="text"><br>
    姓名：<input name="sname" type="text"><br>
    密码：<input name="password" type="password"><br>
    <input type="reset" value="重置">
    <input type="submit" value="提交">
</form>
</body>
</html>

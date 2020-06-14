<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结果</title>
</head>
<body>
<h1>${requestScope.message}</h1>
<h3>即将跳转到管理员界面...</h3>
</body>
<script>
    onload=function () {
        var time = setTimeout(go,2000);
    }
    function go() {
        location.href="user.jsp";
    }
</script>
</html>

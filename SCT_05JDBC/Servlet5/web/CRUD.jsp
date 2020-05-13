<%@ page import="javax.sql.DataSource" %>
<%@ page import="com.mchange.v2.c3p0.ComboPooledDataSource" %>
<%@ page import="org.apache.commons.dbutils.QueryRunner" %>
<%@ page import="java.util.List" %>
<%@ page import="org.apache.commons.dbutils.handlers.ArrayListHandler" %>
<%@ page import="org.apache.commons.dbutils.handlers.ArrayHandler" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>数据库的增删改查</title>
    <style>
        div{
            width: 500px;
            background-color: gold;
            margin:0  auto;
        }
        a:link{
            color: blue;
        }
        a:hover{
            color: red;
        }
        a:active{
            color: purple;
        }
        a:visited{
            color: green;
        }
    </style>
</head>
<script>
    onload = function () {
        <% if(request.getAttribute("create")!=null){
            int result = (int)request.getAttribute("create");
            if(result!=0){%>
        alert("添加成功");
        <%}else{%>
        alert("添加失败");
        <%}
        request.removeAttribute("create");
    }%>

        <% if(request.getAttribute("update")!=null){
            int result = (int)request.getAttribute("update");
            if(result!=0){%>
        alert("修改成功");
        <%}else{%>
        alert("修改失败");
        <%}
        request.removeAttribute("update");
    }%>

        <% if(request.getAttribute("delete")!=null){
            int result = (int)request.getAttribute("delete");
            if(result!=0){%>
        alert("删除成功");
        <%}else{%>
        alert("删除失败");
        <%}
        request.removeAttribute("delete");
}%>
    }

    function deletes() {
        <%
            request.setCharacterEncoding("utf-8");
            String sid = request.getParameter("sid");
            DataSource ds = new ComboPooledDataSource();
            QueryRunner qr = new QueryRunner(ds);
            Object[] results = null;
            String sql = "select * from students where sid=?";
            results = qr.query(sql, new ArrayHandler(),sid);
            if(results!=null){
                String sidvalue = (String)results[0];
                String snamevalue = (String)results[1];
                Date sbirthdayvalue = (Date)results[2];
                String ssexvalue = (String)results[3];
            %>
            var flag = confirm("是否删除学号为：<%=sidvalue%>，姓名为：<%=snamevalue%>，出生日期为：<%=sbirthdayvalue%>，性别为：<%=ssexvalue%>的学生信息?");
            if (flag==true) {
                var form = document.getElementById("testdelete");
                form.submit();
            }
            <%}%>
    }

</script>
<% String name = (String) session.getAttribute("user");
    if (name != null) {%>
    
<body>
<div style="text-align: center">
<h1>学生列表</h1>
<a href="/stu57/create.html">增添学生</a>&nbsp;&nbsp;
<a href="/stu57/retrieve.html">查找学生</a><br>
<%
    request.setCharacterEncoding("utf-8");
    ds = new ComboPooledDataSource();
    qr = new QueryRunner(ds);
    List<Object[]> result = null;
    sql = "select * from students";
    result = qr.query(sql, new ArrayListHandler());
    if (result != null) {
        int i = 0;%>
<table align="center" width="400px" cellspacing="0px" border="1px" bgcolor="aqua">
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>出生日期</td>
        <td>性别</td>
        <td colspan="2">操作</td>
    </tr>
    <%
        for (Object[] obj : result) {
            request.setAttribute("student" + i, obj);
    %>
    <tr>
        <%for (Object objvalue : obj) {%>
        <td><%=objvalue%>
        </td>
        <%}%>
        <td>
            <form id="testdelete" action="/stu57/DeleteServlet" method="get">
                <input type="hidden" id="d" value="<%=obj[0]%>" name="sid">
                <input type="button" onclick="deletes()" value="删除">
            </form>
        </td>
        <td>
            <form action="/stu57/update.jsp" method="get">
                <input type="hidden" id="u" value="<%=obj[0]%>" name="sid">
                <input type="submit" value="修改">
            </form>
        </td>
    </tr>
    <%
            i++;
        }
    %>
</table>
<%}%>

<h3>点击此处<a href="/stu57/logoutServlet">【注销管理员登录】</a></h3>
</div>
</body>
<%} else { %>
<%
    request.setAttribute("unlogin", "请先登录");
    request.getRequestDispatcher("/index.jsp").forward(request, response);
%>
    <%} %>
</html>

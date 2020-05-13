<%@ page import="javax.sql.DataSource" %>
<%@ page import="com.mchange.v2.c3p0.ComboPooledDataSource" %>
<%@ page import="org.apache.commons.dbutils.QueryRunner" %>
<%@ page import="org.apache.commons.dbutils.handlers.ArrayHandler" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生信息</title>
    <style>
        p {
            color: blue;
            font-size: 30px;
            font-weight: bold;
        }

        div {
            width: 300px;
            background-color: pink;
            margin: 0 auto;
        }

        .inp2 {
            width: 150px;
        }
    </style>
</head>
    <%
    request.setCharacterEncoding("utf-8");
    String sid = request.getParameter("sid");
    DataSource ds = new ComboPooledDataSource();
    QueryRunner qr = new QueryRunner(ds);
    Object[] result = null;
    String sql = "select * from students where sid=?";
    result = qr.query(sql, new ArrayHandler(),sid);
    String sidvalue = (String)result[0];
    String snamevalue = (String)result[1];
    Date sbirthdayvalue = (Date)result[2];String ssexvalue = (String)result[3];
     %>
<body>
<div style="text-align: center;">
    <p>学生信息修改</p>
    <form action="/stu57/UpdateServlet" method="get">
        学号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="inp2" type="text" name="ssid"
                                                      value="<%=sidvalue%>" disabled/><br/><br/>
        <input type="hidden" name="sid" value="<%=sidvalue%>">
        姓名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="inp2" type="text" value="<%=snamevalue%>"
                                                      name="sname"/><br/><br/>
        出生日期：<input class="inp2" type="date" value="<%=sbirthdayvalue.toString()%>" name="sbirthday"/><br/><br/>
        性别：男：<input type="radio" name="ssex" value="男"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        女：<input type="radio" name="ssex" value="女"/>&nbsp;&nbsp;&nbsp;&nbsp;<br/><br/>
        <input type="reset" value="重置"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" value="提交"/>
    </form>
</div>
</body>
</html>

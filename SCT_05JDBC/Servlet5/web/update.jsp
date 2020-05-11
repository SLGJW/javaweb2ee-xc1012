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
        p{
            color: blue;
            font-size: 30px;
            font-weight: bold;
        }
        div{
            width: 300px;
            background-color: pink;
            margin:0  auto;
        }
        .inp2{
            width: 150px;
        }
    </style>
</head>
<script>
    <%
    request.setCharacterEncoding("utf-8");
    String sid = request.getParameter("sid");
    DataSource ds = new ComboPooledDataSource();
    QueryRunner qr = new QueryRunner(ds);
    Object[] result = null;
    String sql = "select * from students where sid=?";
    result = qr.query(sql, new ArrayHandler(),sid);
    %>

    onload = function () {
        <%
        String sidvalue = (String)result[0];
        System.out.println(sidvalue);
        String snamevalue = (String)result[1];
        System.out.println(snamevalue);
        Date sbirthdayvalue = (Date)result[2];
        System.out.println(sbirthdayvalue.toString());
        String ssexvalue = (String)result[3];
        System.out.println(ssexvalue);
        %>

        var arr = new Array('<%=sidvalue%>', '<%=snamevalue%>', '<%=sbirthdayvalue%>', '<%=ssexvalue%>');

        var n = document.getElementById('name');
        n.value = arr[1];

        var b = document.getElementById('birthday');
        b.value = arr[2];

        var s = document.getElementById('sex');
        s.value = arr[3];
    }

</script>
<body>
<div style="text-align: center;">
    <p>学生信息修改</p>
    <form action="/stu57/UpdateServlet" method="get">
        学号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="inp2" type="text" name="sid"
                                                      value="<%=sidvalue%>"/><br/><br/>
        <input type="hidden" name="sid" value="<%=sidvalue%>">
        姓名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="inp2" type="text" name="sname"/><br/><br/>
        出生日期：<input class="inp2" type="date" name="sbirthday"/><br/><br/>
        性别：男：<input type="radio" name="ssex" value="men"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        女：<input type="radio" name="ssex" value="women"/>&nbsp;&nbsp;&nbsp;&nbsp;<br/><br/>
        <input type="reset" value="重置"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" value="提交"/>
    </form>
</div>
</body>
</html>

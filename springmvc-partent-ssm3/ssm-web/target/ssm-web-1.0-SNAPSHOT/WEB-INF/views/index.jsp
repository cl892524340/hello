<%--
  Created by IntelliJ IDEA.
  User: 89252
  Date: 2019/11/18
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>编号</th>
        <th>名字</th>
        <th>生日</th>
    </tr>
    <c:forEach items="${dept}" var="d">
        <tr>
            <td>${d.id}</td>
            <td>${d.deptname}</td>
            <td>${d.birthday}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

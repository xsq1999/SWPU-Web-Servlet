<%--
  Created by IntelliJ IDEA.
  User: 86038
  Date: 2020/6/12
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/table.css" />
<html>
<head>
    <title>Viewnews</title>
</head>
<body>
<form action="SaveNewsServlet"  method="post">
    <div>
        ${news.newsDetail}
    </div>
</form>
</body>
</html>

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
    <table class="table">
    <tr>
        <th>ID</th>
        <th>news</th>
        <th>作者</th>
        <th>时间</th>
        <th>类型</th>
    </tr>
     <tr>
         <td>${news.newsID}</td>
         <td>${news.newsTitle}</td>
         <td>${news.newsWriter}</td>
         <td>${news.newsDate}</td>
         <td>${news.newsCon}</td>
     </tr>
    </table>
</form>
</body>
</html>

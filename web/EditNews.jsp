<%--
  Created by IntelliJ IDEA.
  User: 86038
  Date: 2020/6/12
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/table.css" />
<html>

<head>
    <title>Editnews</title>
</head>

<body>
<form action="SaveNewsServlet" method="post">

    <a class="fo">ID</a><input type="text" name="newsID" value="${news.newsID}" />
    <a class="fo">news</a><input type="text" name="newsTitle" value="${news.newsTitle}" />
    <a class="fo">作者</a><input type="text" name="newsWriter" value="${news.newsWriter}" />
    <a class="fo">时间</a><input type="text" name="newsDate" value="${news.newsDate}" />
    <a class="fo">类型</a><input type="text" name="newsCon" value="${news.newsCon}" />
    <input style="margin: 0;" type="submit" value="更新" />
</form>
</body>

</html>

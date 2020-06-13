<%--
  Created by IntelliJ IDEA.
  User: 86038
  Date: 2020/5/8
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>新闻管理</title>
  <link rel="stylesheet" type="text/css" href="css/Iframe.css" />
  <link rel="stylesheet" href="utilLib/bootstrap.min.css" type="text/css" media="screen" />
</head>

<body>
<span class="cp_title">新闻管理</span>
<div class="add_cp">
  <a href="logo.html">+添加新闻</a>
</div>
<div class="table_con">
  <table>
    <tr class="tb_title">
      <td width="10%">ID</td>
      <td width="30%">news</td>
      <td width="12%">作者</td>
      <td width="12%">时间</td>
      <td width="10%">类型</td>
      <td width="26%">操作</td>
    </tr>
    <c:forEach var="news" items = "${lstNews}">
      <tr>
        <td width="5%">${news.getNewsID()}</td>
        <td width="30%">${news.getNewsTitle()}</td>
        <td width="12%">${news.getNewsWriter()}</td>
        <td width="12%">${news.getNewsDate()}</td>
        <td width="10%">${news.getNewsCon()}</td>
        <td width="26%">
          <a href="EditNewsServlet?newsID=${news.newsID}" class="bj_btn">编辑</a>
          <a href="ViewNewsServlet?newsID=${news.newsID}" class="sj_btn">查看</a>
          <a href="DeleteNewsServlet?newsID=${news.newsID}" class="del_btn">删除</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>

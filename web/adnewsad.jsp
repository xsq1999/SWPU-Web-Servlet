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
  <a href="AdAddNews.jsp">+添加新闻</a>
</div>
<div class="add_cp" style="position: absolute;margin-left:1325px;margin-top: 43px;">
  <a href="AdShowNewsServlet">Refresh</a>
</div>
<%--<span style="position: relative; margin-left:23px;margin-top: 30px;font-size: 10px;">当前在线人数：${news.getSession()}</span>--%>
<div class="table_con">
  <table>
    <tr class="tb_title">
      <td width="5%">ID</td>
      <td width="23%">news</td>
      <td width="10%">作者</td>
      <td width="12%">类型</td>
      <td width="18%">时间</td>
      <td width="5%">状态</td>
      <td width="23%">操作</td>
    </tr>
    <c:forEach var="news" items = "${AdlstNews}">
      <tr>
        <td width="5%">${news.getNewsID()}</td>
        <td width="23%">${news.getNewsTitle()}</td>
        <td width="10%">${news.getNewsWriter()}</td>
        <td width="12%">${news.getNewsCon()}</td>
        <td width="18%">${news.getNewsDate()}</td>
        <td width="5%">${news.getNewsAudi()}</td>
        <td width="23%">
          <a href="AdEditNewsServlet?newsID=${news.newsID}" style="margin: 0;padding: 0;display: inline-block;padding-right: 5px"><input class="bj_btn" type="button" value="编辑" /></a>
          <a href="ViewNewsServlet?newsID=${news.newsID}" style="margin: 0;padding: 0;display: inline-block;padding-left: 5px;padding-right: 5px"><input class="sj_btn" type="button" value="查看" /></a>
          <a href="AdDeleteNewsServlet?newsID=${news.newsID}" style="margin: 0;padding: 0;display: inline-block;padding-left: 5px;padding-right: 5px"><input class="del_btn" type="button" value="删除" /></a>
          <a href="AudiNewsServlet?newsID=${news.newsID}" style="margin: 0;padding: 0;display: inline-block;padding-left: 5px;padding-right: 5px"><input style="border:solid 1px lawngreen; background:lawngreen; color:#fff" type="button" value="审核" /></a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>

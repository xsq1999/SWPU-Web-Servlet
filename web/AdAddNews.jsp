<%--
  Created by IntelliJ IDEA.
  User: 86038
  Date: 2020/6/20
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/table.css" />
<html>

<head>
    <title>Addnews</title>
    <script type="text/javascript" charset="utf-8" src="${request.getContextpath()}/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${request.getContextpath()}/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="${request.getContextpath()}/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>


<body>
<form action="AdAddNewsServlet" method="post">

    <a style="font-size: 20px;margin-left: 85px;">ID  </a><input type="text" class="txs" style="margin-left: 42px;" name="newsID" value="" />
    <a style="font-size: 20px;margin-left: 85px;">作者</a><input type="text" class="txs" name="newsWriter" value="" /><br><br>
    <a style="font-size: 20px;margin-left: 85px;">时间</a><input type="text" class="txs" name="newsDate" value="" />
    <a style="font-size: 20px;margin-left: 85px;">类型</a><input type="text" class="txs" name="newsCon" value="" /><br><br>
    <a style="font-size: 20px;margin-left: 85px;">news</a><input type="text" class="tx" name="newsTitle" value="" /><br><br>

    <textarea id="newsDetail" name="newsDetail" style="width: 1100px; height: 400px; margin: 0 auto;" > </textarea><br>

    <input style="border:solid 1px #0c89ff; background:#0c89ff; color:#fff;margin-left: 85px;margin-bottom: 120px;" type="submit" value="更新" />
</form>

<script type="text/javascript">
    var ue = UE.getEditor('newsDetail');
</script>

</body>

</html>

<%--
  Created by IntelliJ IDEA.
  User: IKin
  Date: 2024/1/23
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>编辑新闻</title>
</head>
<body>
<h2>编辑新闻</h2>
<form action="${pageContext.request.contextPath}/news" method="post">
    <div>
        <label for="title">标题:</label>
        <input type="text" id="title" name="title" required value="${news!=null ? news.title : ''}" />
    </div>

    <div>
        <label for="newsContent">内容:</label><br/>
        <textarea id="newsContent" name="newsContent" required style="width: 600px;height:300px;">${news!=null ? news.newsContent : ''}</textarea>
    </div>

    <div>
        <label for="publisher">发布者:</label>
        <input type="text" id="publisher" name="publisher" required value="${news!=null ? news.publisher : ''}"/>
    </div>

    <c:if test="${not empty news}">
        <input type="hidden" id="id" name="id" value="${news.id}">
    </c:if>
    <button id="back" type="button">返回</button>
    &nbsp;
    <input type="submit" value="保存" />
</form>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        var button = document.getElementById("back");

        if (button) {
            button.addEventListener("click", function () {
                window.location.href = "${pageContext.request.contextPath}/";
            });
        }
    });
</script>
</body>
</html>

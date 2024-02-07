<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>新闻明细</title>
</head>
<body>
<h1>新闻明细</h1>
<%--
jsp获取request参数的两种方式：
<h2>${param.id}</h2>
<h2><%=request.getParameter("id")%></h2>
--%>
<button id="back">返回</button>
<h2>${news.title}</h2>
<hr/>
<p>${news.newsContent}</p>
<hr/>
<p>发布者： ${news.publisher}</p>
<p>发布时间： <fmt:formatDate value="${news.gmtCreate}" pattern="yyyy-MM-dd HH:mm"/></p>
<c:if test="${not empty news.gmtModify}">
    <p>修改时间： <fmt:formatDate value="${news.gmtModify}" pattern="yyyy-MM-dd HH:mm"/></p>
</c:if>
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

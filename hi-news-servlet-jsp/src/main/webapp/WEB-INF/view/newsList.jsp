<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>新闻列表</title>
</head>
<body>
<h1>新闻列表</h1>
<button id="add">添加新闻</button>
<table>
    <tr>
        <th>序号</th>
        <th>标题</th>
        <th>发布时间</th>
        <th>操作</th>
    </tr>
    <c:forEach var="news" items="${newsList}">
        <tr>
            <td>${news.id}</td>
            <td>${news.title}</td>
            <td><fmt:formatDate value="${news.gmtCreate}" pattern="yyyy-MM-dd HH:mm"/></td>
            <td>
                &nbsp;
                <button onclick="view('${news.id}')">查看</button>
                &nbsp;
                <button onclick="edit('${news.id}')">编辑</button>
                &nbsp;
                <button onclick="del('${news.id}')">删除</button>
            </td>
        </tr>
    </c:forEach>
</table>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        var addButton = document.getElementById("add");
        if (addButton) {
            addButton.addEventListener("click", function () {
                window.location.href = "${pageContext.request.contextPath}/newsAdd";
            });
        }
    });

    function view(id) {
        window.location.href = "${pageContext.request.contextPath}/news?id=" + id;
    }

    function edit(id) {
        window.location.href = "${pageContext.request.contextPath}/newsEdit?id=" + id;
    }

    function del(id) {
        var confirmDelete = confirm("是否删除该条新闻?");
        if (confirmDelete) {
            var xhr = new XMLHttpRequest();
            var url = "${pageContext.request.contextPath}/news?id=" + id;

            xhr.open("DELETE", url, true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4) { // 成功完成
                    // 判断响应结果:
                    if (xhr.status === 200) {
                        // 成功，通过responseText拿到响应的文本:
                        alert(xhr.responseText);
                        window.location.reload();
                    } else {
                        // 失败，根据响应码判断失败原因:
                        return alert(xhr.status);
                    }
                } else {
                    // HTTP请求还在继续...
                }
            };
            xhr.send();
        }
    }
</script>
</body>
</html>

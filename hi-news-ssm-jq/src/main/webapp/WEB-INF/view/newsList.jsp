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

<script src="${pageContext.request.contextPath}/resources/jquery-2.1.4.js"></script>
<script>
    $(function (){
        $("#add").click(function (){
            window.location.href = "${pageContext.request.contextPath}/news/add";
        });
    });

    function view(id) {
        window.location.href = "${pageContext.request.contextPath}/news/view/" + id;
    }

    function edit(id) {
        window.location.href = "${pageContext.request.contextPath}/news/edit/" + id;
    }

    function del(id) {
        var confirmDelete = confirm("是否删除该条新闻?");
        if (confirmDelete) {
            $.ajax({
                url: "${pageContext.request.contextPath}/news/" + id,
                type: 'DELETE',
                dataType: 'json',
                success: function (result) {
                    console.log(result);
                    if (result.code == 0) {
                        alert("删除成功");
                        window.location.reload();
                    } else {
                        alert(result.msg);
                    }
                }
            });
        }
    }
</script>
</body>
</html>

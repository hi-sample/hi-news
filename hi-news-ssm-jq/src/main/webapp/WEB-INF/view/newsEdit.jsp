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
        <input type="text" id="title" name="title" required value="${news!=null ? news.title : ''}"/>
    </div>

    <div>
        <label for="newsContent">内容:</label><br/>
        <textarea id="newsContent" name="newsContent" required
                  style="width: 600px;height:300px;">${news!=null ? news.newsContent : ''}</textarea>
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
    <input id="submit" type="button" value="保存"/>
</form>

<script src="${pageContext.request.contextPath}/resources/jquery-2.1.4.js"></script>
<script>
    $(function () {
        $("#back").click(function () {
            window.location.href = "${pageContext.request.contextPath}/";
        });
        $("#submit").click(${news!=null ? "edit": "add"});
    });

    <c:if test="${empty news}">

    function add() {
        var title = $('#title').val();
        if (title == '') {
            return alert('请输入新闻标题');
        }
        var newsContent = $('#newsContent').val();
        if (newsContent == '') {
            return alert('请输入新闻内容');
        }
        var publisher = $('#publisher').val();
        if (publisher == '') {
            return alert('请输入发布者');
        }
        $.ajax({
            url: "${pageContext.request.contextPath}/news",
            data: JSON.stringify({
                title: title,
                newsContent: newsContent,
                publisher: publisher
            }),
            contentType: "application/json;charset=UTF-8",
            type: 'POST',
            dataType: 'json',
            error: function (jqXHR, textStatus, errorThrown) {
                //请求失败时调用此函数
                //三个参数:jqXHR 对象、错误信息、（可选）捕获的异常对象
                //如果发生了错误，错误信息（第二个参数）除了得到null之外，还可能是"success", "notmodified", "nocontent", "error", "timeout", "abort", or "parsererror"
                console.log("-----------error-----------");
                console.log(arguments);
                alert("请求失败：" + textStatus);
            },
            success: function (result, textStatus, jqXHR) {
                // data 根据dataType参数进行处理后的数据
                console.log("-----------success-----------");
                console.log(arguments);
                if (result.code == 0) {
                    alert("保存成功");
                    window.location.href = "${pageContext.request.contextPath}/news";
                } else {
                    alert("保存失败:" + result.code + " : " + result.msg);
                }
            }
        });
    }

    </c:if>

    <c:if test="${not empty news}">

    function edit() {
        var title = $('#title').val();
        if (title == '') {
            return alert('请输入新闻标题');
        }
        var newsContent = $('#newsContent').val();
        if (newsContent == '') {
            return alert('请输入新闻内容');
        }
        var publisher = $('#publisher').val();
        if (publisher == '') {
            return alert('请输入发布者');
        }
        $.ajax({
            url: "${pageContext.request.contextPath}/news",
            data: JSON.stringify({
                id: $('#id').val(),
                title: title,
                newsContent: newsContent,
                publisher: publisher
            }),
            contentType: "application/json;charset=UTF-8",
            type: 'PATCH',
            dataType: 'json',
            error: function (jqXHR, textStatus, errorThrown) {
                alert("请求失败：" + textStatus);
            },
            success: function (result, textStatus, jqXHR) {
                if (result.code == 0) {
                    alert("保存成功");
                    window.location.href = "${pageContext.request.contextPath}/news";
                } else {
                    alert("保存失败:" + result.code + " : " + result.msg);
                }
            }
        });
    }

    </c:if>
</script>
</body>
</html>

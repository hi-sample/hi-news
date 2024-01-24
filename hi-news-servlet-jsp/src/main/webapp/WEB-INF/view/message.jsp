<%--
  Created by IntelliJ IDEA.
  User: IKin
  Date: 2024/1/23
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
</head>
<body>
<script>
    // JavaScript 函数，用于弹窗提示
    function showAlert(message, redirectUrl) {
        alert(message);
        // 确认后自动跳转
        window.location.href = redirectUrl;
    }
    showAlert("${message}","${url}");
</script>
</body>
</html>

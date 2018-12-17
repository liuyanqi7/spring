<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
session 中的names是：${sessionScope.names}<br/>
session 中的age是：${sessionScope.age}
<hr/>

modelAndView 取出来的值是：${requestScope.role.roleName}

<hr/>
model取出来的值是：${requestScope.role.roleName}

<hr/>
使用restful风格传递的值是：classid=====${classid},productid=====${productid}


</body>
</html>

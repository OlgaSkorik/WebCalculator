<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator - User</title>
</head>
<body>
<form action="/calcU" method="post">
    <h1>Calculator - User</h1>
    <br><br>
    <input type="number" placeholder="Number 1" name="num1">
    <input type="number" placeholder="Number 2" name="num2">
    <input type="text" placeholder="Operation" name="operation">
    <button>Submit</button>
</form>
<p>${requestScope.result}</p>
<a href="<%=request.getContextPath()%>/history">My operations history</a>
<a href="<%=request.getContextPath()%>/logout">Logout</a>
</body>
</html>

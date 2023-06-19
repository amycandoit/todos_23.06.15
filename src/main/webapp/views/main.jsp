<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MAIN</title>
</head>
<body>
<%@ include file="header.jsp"%>
<%-- 자바문법 쓸때--%>
<%--    <%--%>
<%--      if(session.getAttribute("uid") ==null)--%>
<%--          response.sendRedirect("/login");--%>
<%--    %>--%>

  <img src="/img/ffsf.png">
  <a href="/back">back</a>

    <h1><%=(String) request.getAttribute("uname")%> 안녕하세요!</h1>
    <h1>${uname} 환영합니다!</h1>

    <%@ include file="todos.jsp" %>
    <%@ include file="todolist.jsp" %>
    <%@ include file="keyword.jsp" %>
</body>
</html>
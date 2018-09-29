<%--
  Created by IntelliJ IDEA.
  User: roytrack
  Date: 2015/4/14
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <jsp:include page="import.jsp"/>
    <title></title>
</head>
<body>
<div class="form-group has-success col-md-4">
    <label class="control-label" for="username">username</label>
    <input type="text" class="form-control" id="username">
</div>
<div class="form-group has-success col-md-4">
    <label class="control-label" for="subject">order subject</label>
    <input type="text" class="form-control" id="subject">
</div>
<div class="form-group has-success col-md-4">
    <label class="control-label" for="total">total</label>
    <input type="text" class="form-control" id="total">
</div>
<div class="form-group has-success col-md-4">
    <label class="control-label" for="order_id">order number</label>
    <input type="text" class="form-control" id="order_id">
</div>

<jsp:include page="bodyjs.jsp"/>
</body>
</html>

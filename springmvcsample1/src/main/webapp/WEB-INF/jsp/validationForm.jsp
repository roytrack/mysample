<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/learn/validate/save" method="post">
    <table width="60%" border="0" cellpadding="3" cellspacing="1">
      <tr>
        <td width="15%">角色名</td>
        <td><input type="text" name="name"  />
      </tr>
    </table>
${ctx}@@@
    ${pageContext.request.contextPath}
  <div>
    <h3><input type="submit" value="保存" /><a href="${ctx}/role">返回</a></h3>
  </div>
</form>
</body>
</html>

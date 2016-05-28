<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="css/app.css" />" rel="stylesheet"
	type="text/css">
<title>Greeting Page - ProgrammingFree</title>
</head>
<body>
 <h1>
  Hello <b><c:out value="${pageContext.request.remoteUser}"></c:out></b>
 </h1>
 <form action="/logout" method="post">
  <input type="submit" class="button red big" value="Sign Out" /> <input
   type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
 </form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="css/app.css" />" rel="stylesheet"
	type="text/css">
<title>Login Page - ProgrammingFree</title>
</head>
<body>
 <form action="/login" method="post">
  <div>
   <input type="text" name="username"
    placeholder="User Name" />
  </div>
  <div>
   <input type="password" name="password"
    placeholder="Password" />
  </div>
  <div>
   <input type="submit" value="Sign In" class="button red small" />
  </div>
  <c:if test="${param.error ne null}">
   <div class="alert-danger">Invalid username and password.</div>
  </c:if>
  <c:if test="${param.logout ne null}">
   <div class="alert-normal">You have been logged out.</div>
  </c:if>
  <input type="hidden" name="${_csrf.parameterName}"
   value="${_csrf.token}" />
 </form>

</body>
</html>
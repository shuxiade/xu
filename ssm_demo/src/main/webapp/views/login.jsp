<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/ssm_demo/validate" method="post">
		用户名：<input name="username" type="text" />
		密码：<input name="password" type="password"/>
		<input type="submit" value="提交"/>${error}
	</form>
	
	
</body>
</html>
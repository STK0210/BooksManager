<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/RegProc" method="post">
		<h2>欢迎使用图书管理系统</h2>
		<fieldset>
			<legend>注册界面</legend>
			账号：
			<input type="text" placeholder="请输入账号名称" name="uname">
			<br />
			密码：
			<input type="password" placeholder="请输入密码" name="password">
			<br />
			<input type="submit" value="注册" id="submit">
		</fieldset>
		<a href="${pageContext.request.contextPath}/faces/xhtml/index.xhtml">返回登陆</a>
	</form>

</body>
</html>
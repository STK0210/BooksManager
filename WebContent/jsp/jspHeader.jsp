<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<img src="${pageContext.request.contextPath}/resources/images/header.jpg" />
	<br />
	<c:if test="${not empty user.uname }">
		<span>欢迎${user.uname }</span>
		<span>
			<a href="${pageContext.request.contextPath}/StatelessServlet">查询图书</a>
		</span>
		<span>
			<a href="${pageContext.request.contextPath}/faces/xhtml/addBook.xhtml">添加图书</a>
		</span>
		<span>
			<!-- <a href="${pageContext.request.contextPath}/OrderServlet?method=findMyOrdersWithPage&num=1">图书列表</a> -->
			<a href="${pageContext.request.contextPath}/StatefulServlet">图书列表</a>
		</span>
	</c:if>
	<span>
		<a href="../jsp/register.jsp">注册</a>
	</span>
</body>
</html>
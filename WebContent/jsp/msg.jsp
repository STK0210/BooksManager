<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.container .row div {
	/* position:relative;
	 float:left; */
	
}
</style>
</head>
<body>
	<div class="container">

		<!-- header-->
		<%@ include file="/jsp/jspHeader.jsp"%>
		<h2>${msg }</h2>
		<!-- footer -->
		<%@ include file="/jsp/jspFooter.jsp"%>

	</div>
</body>
</html>
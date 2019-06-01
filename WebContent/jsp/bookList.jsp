<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>图书列表</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" />
<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

.container .row div {
	/* position:relative;
	 float:left; */
	
}

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}
</style>
</head>

<body>

	<div class="container">

		<!-- header-->
		<%@ include file="/jsp/jspHeader.jsp"%>

		<c:if test="${empty books }">
			<div class="row">
				<div class="col-md-12">
					<h1>目前数据库中没有图书...</h1>
				</div>
			</div>
		</c:if>


		<c:if test="${not empty books }">
			<div class="row">
				<div style="margin: 0 auto; margin-top: 10px; width: 950px;">
					<strong style="font-size: 16px; margin: 5px 0;">图书列表</strong>
					<table class="table table-bordered" border="1">
						<tbody>
							<tr class="warning">
								<th>图书名字</th>
								<th>图书书号</th>
								<th>作者</th>
								<th>出版日期</th>
								<th>价格</th>
								<th>类别</th>
								<th>子类别</th>
							</tr>
							<c:forEach items="${books }" var="item">
								<tr class="active">
									<td>${item.bname }</td>
									<td>${item.bnum }</td>
									<td>
										<c:forEach items="${item.authers }" var="auther">
											${auther }&nbsp;&nbsp;
										</c:forEach>
									</td>
									<td>${item.pubDate }</td>
									<td>￥${item.price }</td>
									<td>${item.getKindStr(item.kind)}</td>
									<td>${item.getBidStr(item.bid)}</td>
								</tr>
							</c:forEach>
							<c:if test="${empty books }">
								<a>数据没有成功存储到session中</a>
							</c:if>
						</tbody>
					</table>
				</div>
			</div>
		</c:if>

		<!-- footer -->
		<%@ include file="/jsp/jspFooter.jsp"%>

	</div>
</body>

<script>
	$(function() {
		$(".delete").click(function() {
			if (confirm("确认删除该商品?")) {
				//获取被删除商品的id
				var pid = this.id;
				window.location.href = "/StoreV5/CartServlet?method=removeCartItem&pid=" + pid;
			}
		})
	})
</script>

</html>
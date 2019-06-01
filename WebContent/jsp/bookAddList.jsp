<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>待添加图书列表</title>
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

		<c:if test="${empty addList }">
			<div class="row">
				<div class="col-md-12">
					<h1>${msg }</h1>
					<h1>返回到添加页面来添加图书</h1>
				</div>
			</div>
		</c:if>


		<c:if test="${not empty addList }">
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
								<th>操作</th>
							</tr>
							<c:forEach items="${addList }" var="addItem">
								<tr class="active">
									<td>${addItem.bname }</td>
									<td>${addItem.bnum }</td>
									<td>
										<c:forEach items="${addItem.authers }" var="auther">
											${auther }&nbsp;&nbsp;
										</c:forEach>
									</td>
									<td>${addItem.pubDate }</td>
									<td>￥${addItem.price }</td>
									<td>${addItem.getKindStr(addItem.kind)}</td>
									<td>${addItem.getBidStr(addItem.bid)}</td>
									<td>
										<a href="#">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:if>


		<div style="margin-right: 130px;">
			<div style="text-align: right; margin-top: 10px; margin-bottom: 10px;">
				<a href="#" id="clear" class="clear">清空图书列表</a>
				<a href="${pageContext.request.contextPath}/addBookListServlet">
					<%--提交图书 --%>
					<input type="submit"  width="100" value="提交图书列表" name="submit">
				</a>
			</div>
		</div>

		<!-- footer -->
		<%@ include file="/jsp/jspFooter.jsp"%>

	</div>
</body>

<script>
	$(function() {
		$(".delete").click(function() {
			if (confirm("确认图书该商品?")) {
				//获取被删除图书的id
				var pid = this.id;
				window.location.href = "#";
			}
		})
	})
</script>

</html>
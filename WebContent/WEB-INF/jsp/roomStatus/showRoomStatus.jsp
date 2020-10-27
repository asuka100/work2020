<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctxPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>实时房态</title>
<link rel="stylesheet"
	href="${ctxPath}/layui/css/layui.css?t=1554901098009" media="all">
<style>
body {
	margin: 10px;
}

.demo-carousel {
	height: 200px;
	line-height: 200px;
	text-align: center;
}
</style>

<style>
#tbl {
	margin-top: 15px;
	margin-left: 25px;
}

#tbl th {
	height: 45px;
}

#tbl td {
	font-weight: normal;
	height: 45px;
	font-family: 微软雅黑;
	font-size: 17px;
}

#tbl [type='text'] {
	height: 28px;
	font-size: 17px;
	text-indent: 0.3em;
}

#tbl select {
	width: 200px;
	height: 32px;
	font-size: 17px;
}

#tbl td:nth-child(1) {
	width: 80px;
}

#tbl td:nth-child(2) {
	width: 350px;
}
</style>

<script type="text/javascript">
	
</script>

</head>
<script src="${ctxPath}/layui/layui.js?t=1554901098009" charset="utf-8">
	
</script>
<script src="${ctxPath}/jq_package/jquery-1.8.3.min.js"></script>
<body>

	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>实时房态</legend>
	</fieldset>
	<table>
		<div class="layui-row layui-col-space5 " style="position:relative; height:600px; overflow:auto">


			<div class="layui-col-md1"></div>
			<div class="layui-col-md10">

				<c:forEach items="${list}" var="room">


					<div class="layui-col-md3"
						style="margin-left: 10px; margin-bottom: 15px; border: 1px solid gray;">
						<c:if test="${room.roomStatusId=='1'}">
							<div class="grid-demo "
								style="background-color: green; height: 150px">
						</c:if>
						<c:if test="${room.roomStatusId=='2'||room.roomStatusId=='3'}">
							<div class="grid-demo "
								style="background-color: gray; height: 150px">
						</c:if>
						<c:if test="${room.roomStatusId=='4'}">
							<div class="grid-demo "
								style="background-color: red; height: 150px">
						</c:if>
						<c:if test="${room.roomStatusId=='5'}">
							<div class="grid-demo "
								style="background-color: blue; height: 150px">
						</c:if>


						<div style="height: 30px; padding-left: 10px; color: white;">${room.roomId }房</div>

						<div
							style="height: 90px; padding-left: 10px; color: white; text-align: center; line-height: 90px;">${room.roomStatus.statusName }</div>


						<div
							style="background-color: rgba(200, 200, 200, 0.75); height: 30px; text-align: center; color: white; line-height: 30px">${room.roomType.typeName }</div>

					</div>
			</div>
			</c:forEach>
			<div class="layui-col-md10"style="height: 50px"></div>
		
		</div>


		</div>
	</table>

</body>

</html>


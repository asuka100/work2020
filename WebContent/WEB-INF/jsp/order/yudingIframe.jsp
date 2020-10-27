<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${ctxPath}/layui/css/layui.css?t=1554901098009" media="all">
<script src="${ctxPath}/jq_package/jquery-1.8.3.min.js"></script>
    <style>
        body{margin: 10px;}
        .demo-carousel{height: 200px; line-height: 200px; text-align: center;}
    </style>
</head>
<body>
<form class="layui-form" id="form-recover">
	<div class="layui-form-item">
		<label class="layui-form-label">姓名：</label>
	    <div class="layui-input-block">
	      <input type="text" name="name" lay-verify="title" autocomplete="off" placeholder="请输入客户姓名" class="layui-input">
    	</div>
	</div>
	
	<div class="layui-form-item">
		<label class="layui-form-label">身份证号：</label>
	    <div class="layui-input-block">
	      <input type="text" name="cardId" lay-verify="identity" placeholder="请输入客户的身份证号" autocomplete="off" class="layui-input">
    	</div>
	</div>
	
	<div class="layui-form-item">
		<label class="layui-form-label">电话号码：</label>
	    <div class="layui-input-block">
	      <input type="tel" name="phone" lay-verify="required|phone" placeholder="请输入客户的电话号码" autocomplete="off" class="layui-input">
    	</div>
	</div>
	
	<div class="layui-form-item">
		<label class="layui-form-label">性别：</label>
	    <div class="layui-input-block">
	      <input type="text" name="sex" lay-verify="title" autocomplete="off" placeholder="请输入性别" class="layui-input">
    	</div>
	</div>
	
	<div class="layui-form-item">
    <div class="layui-input-block">
      <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1" id="bbbb">预定</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
  
	<input type="hidden" id="employeeId" name="employeeId" value="${employee.employeeId }" />
	<!-- <input type="hidden" id="employeeIdInput" name="roomId" /> -->
	
</form>

<script type="text/javascript">
	
	var roomId = sessionStorage.getItem("yudingRoomId");
	$('#employeeIdInput').val(roomId);
	
	$(function(){
		$('#bbbb').val(roomId);
		
	})
	
	console.log(22333)
	
	$('#form-recover').submit(function(){
		console.log("表单提交")
		$.ajax({
			async : false, 
			type:"POST",
			url: '${ctxPath}/order/create2',
			data: $('#form-recover').serialize(),
			success: function(){
				console.log("recover,success");
				$.ajax({
					async : false, 
					
				})
			}
		})
	});
	
	
</script>
</body>
</html>
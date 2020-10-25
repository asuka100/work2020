<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>新增房间类型</title>
    <link rel="stylesheet" href="${ctxPath}/layui/css/layui.css" media="all">
    <script src="${ctxPath}/layui/layui.js" charset="utf-8"></script>
    <script src="${ctxPath}/jq_package/jquery-1.8.3.min.js"></script>
    <script src="${ctxPath}/js/form.js"></script>
    <script>

    </script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>新增房间类型</legend>
</fieldset>

<form class="layui-form" action="" style="margin-top: 50px">
    <div class="layui-form-item">
        <label class="layui-form-label">类型名称</label>
        <div class="layui-input-inline">
            <input  type="text" name="typeName" required  lay-verify="required" placeholder="请输入类型名称" autocomplete="off" class="layui-input">
        </div>
    </div>










    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">添加</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script>








    layui.use('form', function(){
        var form = layui.form;


        //监听提交
        form.on('submit(formDemo)', function(data){

            $.ajax({
                url: '${ctxPath}/roomType/create',
                data: data.field,
                type: 'post',
                dataType: 'json',
                success: function(resp){
                    //
                    console.log(resp);
                    
                    if(resp == 1){
                        layer.msg('添加房间类型成功');
                        //跳转列表页
                        setTimeout(reloadPage,1000);
                    }
                    else{
                        layer.msg('添加房间类型失败');
                    }
                   
                        setTimeout(reloadPage,1500);
                 
                }
            });

            return false;
        });
    });
    function reloadPage(){
        window.location = '${ctxPath}/roomType/viewRoomTypeList';
    }
</script>
</body>
</html>


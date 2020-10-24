<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>新增客户</title>
    <link rel="stylesheet" href="${ctxPath}/layui/css/layui.css" media="all">
    <script src="${ctxPath}/layui/layui.js" charset="utf-8"></script>
    <script src="${ctxPath}/jq_package/jquery-1.8.3.min.js"></script>
    <script src="${ctxPath}/js/form.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>新增客户</legend>
</fieldset>

<form class="layui-form" action="" style="margin-top: 50px">
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-inline">
            <input  type="text" name="name" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
        </div>
    </div>
   
    <div class="layui-form-item">
        <label class="layui-form-label">电话号码</label>
        <div class="layui-input-inline">
            <input  type="text" name="phone" required  lay-verify="required" placeholder="请输入电话号码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">身份证号</label>
        <div class="layui-input-inline">
            <input  type="text" name="cardId" required  lay-verify="required" placeholder="请输入身份证号" autocomplete="off" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="radio" name="sex" value="男" title="男" checked>
            <input type="radio" name="sex" value="女" title="女" >
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
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
                url: '${ctxPath}/client/create',
                data: data.field,
                type: 'post',
                dataType: 'json',
                success: function(resp){
                    //
                    console.log(resp);
                  
            		if(resp != null){
                        layer.msg("添加："+resp['name']+'成功');
                        setTimeout(reloadPage,1500);
                    }else{
                        layer.msg("添加："+resp['name']+'失败');

                    }
                   
                }
            });
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
    function reloadPage(){
        window.location = '${ctxPath}/User/viewList';
    }
</script>
</body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>新增维修项目</title>
    <link rel="stylesheet" href="${ctxPath}/layui/css/layui.css" media="all">
    <script src="${ctxPath}/layui/layui.js" charset="utf-8"></script>
    <script src="${ctxPath}/jq_package/jquery-1.8.3.min.js"></script>
    <script src="${ctxPath}/js/form.js"></script>
    <script>
        $(function () {


        });


    </script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>新增维修项目</legend>
</fieldset>

<form class="layui-form" action="" style="margin-top: 50px">
    <div class="layui-form-item">
        <label class="layui-form-label">房间编号</label>
        <div class="layui-input-inline">
            <input  type="text" name="roomId" required  lay-verify="required" placeholder="请输入房间编号" autocomplete="off" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">维护员工</label>
        <div class="layui-input-inline">
            <select name="employeeIdList" lay-verify="required" id="employeeIdList">
                <option value="">请选择员工</option>


            </select>
        </div>
    </div>
    
      <div class="layui-form-item">
        <label class="layui-form-label">维修内容</label>
        <div class="layui-input-inline">
            <input  type="text" name="content" required  lay-verify="required" placeholder="请输入维修内容" autocomplete="off" class="layui-input">
        </div>
    </div>

   
    <div class="layui-form-item">
        <label class="layui-form-label">维修状态</label>
        <div class="layui-input-block">
            <input type="radio" name="status" value="未完成" title="未完成" checked>
            <input type="radio" name="status" value="已完成" title="已完成" >
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
        var ran = Math.random()*1000;

        $.ajax({
            url:"${ctxPath}/employee/findAllMaintainEmployee?ran="+ran,
            type:"get",
            dataType:'json',
            success:function (data) {

                for(var i=0;i<data['employeeList'].length; i++){

                    $("#employeeIdList").append("<option value=\""+data['employeeList'][i].employeePositionId+"\">"+data['employeeList'][i].name+"</option>");

                }
                form.render();

            }
        });
 


        //监听提交
        form.on('submit(formDemo)', function(data){

            $.ajax({
                url: '${ctxPath}/maintainlist/create',
                data: data.field,
                type: 'post',
                dataType: 'json',
                success: function(resp){
                    //
                    console.log(resp);
                   
                    if(resp == 1){
                        layer.msg('添加维修项目成功');
                        //跳转列表页
                        setTimeout(reloadPage,1000);
                    }
                    else{
                        layer.msg('添加维修项目失败');
                    }
                 
                }
            });

            return false;
        });
    });
    function reloadPage(){
        window.location = '${ctxPath}/maintainlist/viewMaintainList';
    }
</script>
</body>
</html>


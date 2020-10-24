<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>客户列表</title>
    <link rel="stylesheet" href="${ctxPath}/layui/css/layui.css?t=1554901098009" media="all">
    <style>
        body{margin: 10px;}
        .demo-carousel{height: 200px; line-height: 200px; text-align: center;}
    </style>

    <style>
        #tbl{ margin-top:15px; margin-left:25px; }
        #tbl th{ height:45px; }
        #tbl td{
            font-weight:normal; height:45px;
            font-family:微软雅黑; font-size:17px;
        }
        #tbl [type='text']{
            height:28px; font-size:17px;
            text-indent:0.3em;
        }
        #tbl select { width:200px; height:32px; font-size:17px; }
        #tbl td:nth-child(1){ width:80px; }
        #tbl td:nth-child(2){ width:350px; }
    </style>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>客户列表</legend>
</fieldset>

<table class="layui-hide" id="demo" lay-filter="test"></table>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="${ctxPath}/layui/layui.js?t=1554901098009" charset="utf-8">
</script>
<script src="${ctxPath}/jq_package/jquery-1.8.3.min.js"></script>


<script>
    layui.config({
        version: '1554901098009' //为了更新 js 缓存，可忽略
    });

    layui.use(
        ['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider'],
        function(){
            var laydate = layui.laydate //日期
                ,laypage = layui.laypage //分页
                ,layer = layui.layer //弹层
                ,table = layui.table //表格
                ,carousel = layui.carousel //轮播
                ,upload = layui.upload //上传
                ,element = layui.element //元素操作
                ,slider = layui.slider //滑块


            layer.msg('正在展示客户列表...');
            

            //{ps} 监听Tab切换
            element.on('tab(demo)', function(data){
                layer.tips('切换了 '+ data.index +': '+ this.innerHTML, this, {
                    tips: 1
                });
            });

            //{ps} 执行一个 table 实例
            var ran = Math.random();
            table.render({
                elem: '#demo'
                ,height: 530
                ,url: '${ctxPath}/client/select/all?ran='+ ran //数据接口
                ,title: '客户表'
                ,page: true     //{ps} 开启分页
               
                ,totalRow: false //{ps} 开启合计行
                ,cols: [[       //{ps} 表头
                  

                    {field: 'clientId', title: 'ID', width:80, sort: true, align:'center', fixed: 'left'},
                    {field: 'name', title: '姓名', sort: true, align:'center', width:120},
                    {field: 'sex', title: '性别', sort: true, align:'center', width:80},
                    {field: 'phone', title: '电话号码', sort: true, align:'center', width:150},
                    {field: 'cardId', title: '身份证号', sort: true, align:'center', width:200},
                 

                    {fixed: 'right', title: '操作', width: 185, align:'center', toolbar: '#barDemo'}
                ]]
            });

          

            //{ps} 监听行工具事件
            table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
                var data = obj.data     //获得当前行数据
                    , layEvent = obj.event; //获得 lay-event 对应的值

                if(layEvent === 'detail'){
                    layer.msg('查看操作');
                } else if(layEvent === 'del'){
                    layer.confirm('真的删除客户么', function(index){
                        console.log( data['clientId'] );
                        delClient( data['clientId'] );
                    });
                } else if(layEvent === 'edit'){
                    //{1} 获取一个客户, 通过 ajax 来获取。
                    //  data['clientId']: 表格上面的 clientId 值。
                    editClient( data['clientId'] );
                }
            });

         

         

            //分页
            laypage.render({
                elem: 'pageDemo' //分页容器的id
                ,count: 8        //总页数
                ,skin: '#1E9FFF' //自定义选中色值
                //,skip: true    //开启跳页
                ,jump: function(obj, first){
                    if(!first){
                        layer.msg('第'+ obj.curr +'页', {offset: 'b'});
                      
                    }
                }
            });

            //上传
            upload.render({
                elem: '#uploadDemo'
                ,url: '' //上传接口
                ,done: function(res){
                    console.log(res)
                }
            });

            slider.render({
                elem: '#sliderDemo'
                ,input: true //输入框
            });

        });
</script>

<!-- {ps} 引入  form.js  -->
<script src="${ctxPath}/js/form.js"></script>

<!-- {ps} 编写我们的 js 代码! -->
<script>
  
    //{ps} 这个是下拉列表{选项数据}
    var sex_data = [
        {text:"请选择性别",val:""},
        {text:"男",val:"男"},
        {text:"女",val:"女"}
    ];


    //readonly: 只读文本框
    //type: 组件类型 (text:文本框, select:下拉列表, hide:隐藏域)
    //options: 选项数据。

    //{ps} 规定了弹框中会显示到哪些表单项目。
    //name: 要和后台 JavaBean 命名一样。
    var gInputs = [
      
        {title:"用户姓名", name:"name", type:"text"},
        {title:"设置电话号码", name:"phone", type:"text"},
        {title:"设置性别", name:"sex", type:"select",options:sex_data},
        {title:"身份证号", name:"cardId", readonly:"readonly", type:"text"},
        {name:"clientId", type:"hide"}
    ];


    function editClient( clientId ){
        $.ajax(
            {
                url:'${ctxPath}/client/select/'+clientId, /* 数据接口 */
                type:'post',
                dataType:'json',
                success:function( resp ){
                    if( resp['result']=='success' ){
                        console.log( resp['client'] );
                        onRecvMsg( resp );   //显示对话框
                    }else{
                        layer.msg('访问数据错误。');
                    }
                }
            }
        );
    }

    //{ps} 当接收到后台发来的 用户数据时，触发该方法。
    //     这一个方法会传一个 json 进来。
    function onRecvMsg( json ){
        //{ps} 生成表格 HTML
        var HTML = makeTable( gInputs, json['client'] );
        //{ps} 弹出一个对话框。
        layer.open({
            type: 1
            ,title: '编辑客户'      //显示标题栏
            ,closeBtn: false
            ,area: ['450px','350px']
            ,shade: 0
            ,id: 'LAY_layuipro'   //设定一个 id, 防止重复弹出
            ,btn: ['保存客户', '关闭对话框']  //{ps} 两个按钮
            ,btnAlign: 'c'        //居中对齐
            ,moveType: 1          //拖拽模式, 0 或者 1
            ,content: HTML        //这是上面生成的表格 html 代码
            ,yes: function(){
                //{1} 当点击 '保存用户' 时候, 调用这个函数
                updateClient();       //保存用户(写到数据库)
                //不建议这里关闭, 等消息回来才做。
                //layer.closeAll(); //关闭对话框
            }
            ,success: function( layero ){
                //-----
            }
        });
    }    //ENDING {onRecvMsg}

    //{1} 清除页面中的 maketable
    //{2} 除页面中的 showBox

    //{ps}你要获取的项目
    var items = [
        "clientId", "name", "phone", "sex",
        "cardId"
    ];

    //{ps} 抓取表单数据
    function pickData(){
        var obj = {};
        for( var i=0; i<items.length; i++ ){
            var val = $("#"+ items[i]).val();
            obj[ items[i] ] = val;
        }
        return obj;
    }

    /*
     *  函数:    saveUser
     *  提交数据, 通过 ajax 对象。
     *	提交地址: /User/saveUser
     */
    function updateClient(){
        //{1}获取表单数据。
        var _client = pickData();
        console.log( _client );
        //{2}使用ajax提交数据
        $.ajax({
            url: '${ctxPath}/client/update',
            data: _client,
            type: 'post',
            dataType: 'json',
            success: function(resp){
                //
                console.log(resp);
              
                layer.closeAll();
                if(resp == 1){
                    layer.msg("更新客户："+_client['name']+'  成功');
                    setTimeout(reloadPage,1500);
                }else{
                    layer.msg("更新客户: "+_client['name']+"  失败:");

                }
            }

        });
    }

    function reloadPage(){
        window.location = '${ctxPath}/client/viewClientList';
    }

    function delClient(clientId) {
        $.ajax({
            url: '${ctxPath}/client/delete/'+clientId,
          
            success: function (data) {
                if(data == 1){
                    layer.closeAll();
                    layer.msg('删除成功');
                    setTimeout(reloadPage,1000);
                }else{
                	 layer.closeAll();
                     layer.msg('删除失败');
                }

            }
        });
    }
</script>

</body>
</html>


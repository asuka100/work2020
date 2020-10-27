<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>订单查询</title>
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
    <legend>订单查询</legend>
</fieldset>

<table class="layui-hide" id="demo" lay-filter="test"></table>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">查看明细</a>
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

           
            layer.msg('正在展示订单列表...');
            

            //{ps} 监听Tab切换
            element.on('tab(demo)', function(data){
                layer.tips('切换了 '+ data.index +': '+ this.innerHTML, this, {
                    tips: 1
                });
            });

            //{ps} 执行一个 table 实例
            var ran = Math.random();
            function createTime(v){
        		var date = new Date(v);
        	    var y = date.getFullYear();
        	    var m = date.getMonth()+1;
        	    m = m<10?'0'+m:m;
        	    var d = date.getDate();
        	    d = d<10?("0"+d):d;
        	    var h = date.getHours();
        	    h = h<10?("0"+h):h;
        	    var M = date.getMinutes();
        	    M = M<10?("0"+M):M;
        	    var str = y+"-"+m+"-"+d+" "+h+":"+M;
        	    return str;
        	}
            
            function showEmployeeName(employee){
            	if(employee==null){
            		return "无";
            	}else{
            		return employee['name'];
            	}
            	
            }
            table.render({
                elem: '#demo'
                ,height: 530
                ,url: '${ctxPath}/order/select/all?ran='+ ran //数据接口
                ,title: '订单表'
                ,page: true     //{ps} 开启分页
                ,totalRow: false //{ps} 开启合计行
                ,cols: [[       //{ps} 表头
                  
                   
                    {field: 'orderId', title: '订单编号', width:100, sort: true,align:'center'},  
                           

                    {templet:'<div>{{d.client.name}}</div>',title: '客户名', width: 150, sort: true, align:'center'},
                    {field:'createEmployee',title: '创建订单人员', width: 150, sort: true, align:'center',templet: function (row){
                        return showEmployeeName(row.createEmployee);
                    }}, 
                    {field:'checkEmployee',title: '入住订单人员', width: 150, sort: true, align:'center',templet: function (row){
                        return showEmployeeName(row.checkEmployee);
                    }}, 
                    {field:'payEmployee',title: '结账人员', width: 150, sort: true, align:'center',templet: function (row){
                        return showEmployeeName(row.payEmployee);
                    }}, 
                
                    {field: 'status', title: '状态', width:100 ,sort: true},
                    {field: 'totalPrice', title: '总价', width:100, sort: true,align:'center'},
                    {field: 'date', title: '订单创建日期', width:200, sort: true,align:'center',templet: function (row){
                        return createTime(row.date);
                    }},          
                 
                    {fixed: 'right',title: '操作', width: 185, align:'center', toolbar: '#barDemo'}
                ]]
            });

         

            //{ps} 监听行工具事件
            table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
                var data = obj.data     //获得当前行数据
                    , layEvent = obj.event; //获得 lay-event 对应的值

                if(layEvent === 'detail'){
                    layer.msg('查看操作');
                } else if(layEvent === 'del'){
                    layer.confirm('真的删除订单么', function(index){
                        console.log( data['orderId'] );
                         delOrder( data['orderId'] );
                    });
                } else if(layEvent === 'edit'){
                    //{1} 获取一个房间, 通过 ajax 来获取。
                    //  data['id']: 表格上面的 id 值。
                  
                    editOrder( data['orderId'] );
                  
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
                        alert( "TTTTTTTTT" );
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
    // 临时写死数据, 后面有时间再写一方法, 从后台获取。
    
    $(function(){
    	getTypeData();
    	getStatusData();
    });
    var type_data = [];
    type_data[0]={text:"请选择房间类型",val:"0"};
  


    function getTypeData(){
        var ran = Math.random();
        $.ajax({
            url:"${ctxPath}/roomType/findAll?ran="+ran,
            type:"get",
            dataType:'json',
            success:function (data) {


                for(var i=0;i<data.length; i++){
                    console.log(data[i].typeName);
                    console.log(data[i].roomTypeId);

                    type_data[i+1] = {text: data[i].typeName, val: data[i].roomTypeId};

                }
               
            }
        });
    }

    //{ps} 这个是下拉列表{选项数据}
    var status_data = [];
    status_data[0] = {text:"请选择空闲情况",val:"0"};
   
   

    function getStatusData(){
        var ran = Math.random();
        $.ajax({
            url:"${ctxPath}/roomStatus/list?ran="+ran,
            type:"get",
            dataType:'json',
            success:function (data) {


                for(var i=0;i<data.length; i++){
                    console.log(data[i].statusName);
                    console.log(data[i].roomStatusId);

                    status_data[i+1] = {text: data[i].statusName, val: data[i].roomStatusId};

                }
               
            }
        });
    }
    
    
    //readonly: 只读文本框
    //type: 组件类型 (text:文本框, select:下拉列表, hide:隐藏域)
    //options: 选项数据。

    //{ps} 规定了弹框中会显示到哪些表单项目。
    //name: 要和后台 JavaBean 命名一样。
    function getInputs(){
        var gInputs = [
            {title:"房间编号", name:"roomId", readonly:"readonly", type:"text"},
            {title:"设置房间类型", name:"roomTypeId", type:"select",options:type_data},
           
            {title:"设置房间描述", name:"descriptions", type:"text"}
        ];
        return gInputs;
    }



    function editOrder( orderId ){
        $.ajax(
            {
                url:'${ctxPath}/order/select/orderId', /* 数据接口 */
                type:'post',
                data:{orderId:orderId},
                dataType:'json',
                success:function( resp ){
                    if( resp!=null){
                        console.log( resp['orderDetail']+"------" );
                        getTypeData();
                        getStatusData();
                      
                    	onRecvMsg(resp);

                    }else{
                        layer.msg('访问数据错误。');
                    }
                }
            }
        );
    }

    //{ps} 当接收到后台发来的 房间数据时，触发该方法。
    //     这一个方法会传一个 json 进来。
    function onRecvMsg( json ){
        //{ps} 生成表格 HTML
        var input = getInputs();

        var HTML = makeTable( input, json['orderDetail'] );
        //{ps} 弹出一个对话框。
        layer.open({
            type: 1
            ,title: '查看订单明细'      //显示标题栏
            ,closeBtn: false
            ,area: ['450px','350px']
            ,shade: 0
            ,id: 'LAY_layuipro'   //设定一个 id, 防止重复弹出
            ,btn: ['保存房间', '关闭对话框']  //{ps} 两个按钮
            ,btnAlign: 'c'        //居中对齐
            ,moveType: 1          //拖拽模式, 0 或者 1
            ,content: HTML        //这是上面生成的表格 html 代码
            ,yes: function(){
                //{1} 当点击 '保存房间' 时候, 调用这个函数
                udateRoom();       //保存房间(写到数据库)
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
        "roomId", "roomTypeId", "roomStatusId", "descriptions"
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
    function udateRoom(){
        //{1}获取表单数据。
        var _room = pickData();
        console.log( _room );
        //{2}使用ajax提交数据
        $.ajax({
            url: '${ctxPath}/room/update',
            data: _room,
            type: 'post',
            dataType: 'json',
            success: function(resp){
                //
                console.log(resp);
               
                layer.closeAll();
              
                if(resp == 1){
                    layer.msg('更新房间成功');
                    //跳转列表页
                    setTimeout(reloadPage,1000);

                }else{
                	layer.msg('更新房间失败');
                }
               
            }

        });
    }

    function reloadPage(){
        window.location = '${ctxPath}/room/viewRoomList';
    }

    function delRoom(_id) {
        $.ajax({
            url: '${ctxPath}/room//delete/id',
            data: {'id':_id},
            success: function (data) {
                if(data == 1){
                    layer.closeAll();
                    layer.msg('删除成功');
                    setTimeout(reloadPage,1000);
                }else{
                	 layer.msg('删除失败');
                }

            }
        });
    }
</script>

</body>
</html>


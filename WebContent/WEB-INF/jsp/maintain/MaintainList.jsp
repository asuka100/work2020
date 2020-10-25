<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>房间列表</title>
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
    <legend>房间列表</legend>
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

            //{ps} ?addUser=1
            var addUser = "${param['addUser']}";
            if( addUser=='1' ){
                layer.msg('添加房间成功...');
            }else{
                layer.msg('正在展示房间列表...');
            }

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
                ,url: '${ctxPath}/Room/jsonRoomList?ran='+ ran //数据接口
                ,title: '房间表'
                ,page: true     //{ps} 开启分页
                ,toolbar: 'default' //{ps} 开启工具栏，此处显示默认图标，可以自定义模板，详见文档
                ,totalRow: false //{ps} 开启合计行
                ,cols: [[       //{ps} 表头
                    {type: 'checkbox', fixed: 'left'},

                    {field: 'id', title: '序号', width:120, sort: true, fixed: 'left'},
                    {field: 'roomNo', title: '房间编号', width:120 ,sort: true, },
                    {field: 'typeName', title: '房间类型', width:200, sort: true, },
                    {field: 'storeyId', title: '所属楼层', width:120 ,sort: true, },
                    {field: 'status', title: '空闲情况', width:120, sort: true, },
                    {fixed: 'right', width: 185, align:'center', toolbar: '#barDemo'}
                ]]
            });

            //{ps} 监听头工具栏事件
            table.on('toolbar(test)', function(obj){
                var checkStatus = table.checkStatus(obj.config.id)
                    ,data = checkStatus.data; //获取选中的数据
                switch(obj.event){
                    case 'add':
                        window.location = '${ctxPath}/Room/viewAddRoom';
                        break;
                    case 'update':
                        if(data.length === 0){
                            layer.msg('请选择一行');
                        } else if(data.length > 1){
                            layer.msg('只能同时编辑一个');
                        } else {
                            editRoom(checkStatus.data[0].id);
                        }
                        break;
                    case 'delete':
                        if(data.length === 0){
                            layer.msg('请选择一行');
                        } else {
                            var temp = [];
                            for(var i=0; i<checkStatus.data.length;i++){
                                temp[i] = checkStatus.data[i].id;
                            }
                            layer.confirm('真的删除房间么', function(index){

                                delRoom( temp.toString() );
                            });
                        }
                        break;
                };
            });

            //{ps} 监听行工具事件
            table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
                var data = obj.data     //获得当前行数据
                    , layEvent = obj.event; //获得 lay-event 对应的值

                if(layEvent === 'detail'){
                    layer.msg('查看操作');
                } else if(layEvent === 'del'){
                    layer.confirm('真的删除房间么', function(index){
                        console.log( data['id'] );
                         delRoom( data['id'] );
                    });
                } else if(layEvent === 'edit'){
                    //{1} 获取一个房间, 通过 ajax 来获取。
                    //  data['id']: 表格上面的 id 值。
                    editRoom( data['id'] );
                }
            });

            //执行一个轮播实例
            carousel.render({
                elem: '#test1'
                ,width: '100%' //设置容器宽度
                ,height: 200
                ,arrow: 'none' //不显示箭头
                ,anim: 'fade' //切换动画方式
            });

            //将日期直接嵌套在指定容器中
            var dateIns = laydate.render({
                elem: '#laydateDemo'
                ,position: 'static'
                ,calendar: true //是否开启公历重要节日
                ,mark: { //标记重要日子
                    '0-10-14': '生日'
                    ,'2018-08-28': '新版'
                    ,'2018-10-08': '神秘'
                }
                ,done: function(value, date, endDate){
                    if(date.year == 2017 && date.month == 11 && date.date == 30){
                        dateIns.hint('一不小心就月底了呢');
                    }
                }
                ,change: function(value, date, endDate){
                    layer.msg(value)
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
    var type_data = [];
    type_data[0]={text:"请选择房间类型",val:""};
    type_data[1] = {text: "标准单人房", val: "1"};
    type_data[2] ={text: "标准双人房", val: "2"};
    type_data[3] =  {text: "豪华单人房", val: "3"};
    type_data[4] = {text: "豪华双人房", val: "4"};


    function getTypeData(){
        var ran = Math.random();
        $.ajax({
            url:"${ctxPath}/RoomType/findAllRoomType?ran="+ran,
            type:"get",
            dataType:'json',
            success:function (data) {


                for(var i=0;i<data['roomTypeList'].length; i++){
                    console.log(data['roomTypeList'][i].typeName);
                    console.log(data['roomTypeList'][i].id);

                    type_data[i+1] = {text: data['roomTypeList'][i].typeName, val: data['roomTypeList'][i].id};

                }

            }
        });
    }

    //{ps} 这个是下拉列表{选项数据}
    var status_data = [];
    status_data[0] = {text:"请选择空闲情况",val:""};
    status_data[1] = {text:"空闲",val:"空闲"};
    status_data[2] = {text:"使用中",val:"使用中"};


    //readonly: 只读文本框
    //type: 组件类型 (text:文本框, select:下拉列表, hide:隐藏域)
    //options: 选项数据。

    //{ps} 规定了弹框中会显示到哪些表单项目。
    //name: 要和后台 JavaBean 命名一样。
    function getInputs(){
        var gInputs = [
            {title:"房间编号", name:"roomNo", readonly:"readonly", type:"text"},
            {title:"设置房间类型", name:"typeId", type:"select",options:type_data},
            {title:"所属楼层", name:"storeyId", readonly:"readonly", type:"text"},
            {title:"设置空闲情况", name:"status", type:"select",options:status_data},
            {name:"id", type:"hide"}
        ];
        return gInputs;
    }



    function editRoom( roomId ){
        $.ajax(
            {
                url:'${ctxPath}/Room/getRoom', /* 数据接口 */
                type:'post',
                data:{id:roomId},
                dataType:'json',
                success:function( resp ){
                    if( resp['result']=='success' ){
                        console.log( resp['room'] );
                        getTypeData();
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

        var HTML = makeTable( input, json['room'] );
        //{ps} 弹出一个对话框。
        layer.open({
            type: 1
            ,title: '编辑房间'      //显示标题栏
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
        "id", "roomNo", "typeId", "storeyId",
        "status"
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
            url: '${ctxPath}/Room/updateRoom',
            data: _room,
            type: 'post',
            dataType: 'json',
            success: function(resp){
                //
                console.log(resp);
                var result = resp['result'];
                layer.closeAll();
                var errorCode = resp['errorCode'];
                if(errorCode == 0){
                    layer.msg('更新房间成功');
                    //跳转列表页
                    setTimeout(reloadPage,1000);

                }
                if( errorCode == 2 ){
                    layer.msg('更新房间失败');
                }
            }

        });
    }

    function reloadPage(){
        window.location = '${ctxPath}/Room/viewList';
    }

    function delRoom(_id) {
        $.ajax({
            url: '${ctxPath}/Room/deleteRoom',
            data: {'id':_id},
            success: function (data) {
                if(data == 'success'){
                    layer.closeAll();
                    layer.msg('删除成功');
                    setTimeout(reloadPage,1000);
                }

            }
        });
    }
</script>

</body>
</html>


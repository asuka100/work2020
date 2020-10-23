<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>酒店管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">

    <link rel="stylesheet" href="${ctxPath}/layui/css/layui.css?t=1554901098009"  media="all">

    <style>
        #primaryWin{
            width:100%;
            height:100%;
        }
    </style>

    <script>
        function gotoPage( url ){
            var obj = document.getElementById('primaryWin');
            obj.src = '${ctxPath}'+ url;
        }
    </script>

</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">高级商务酒店管理系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
      

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="${ctxPath}/layui/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"
                         class="layui-nav-img">
                    ${employee.name}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="${ctxPath}/User/back">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
<!-- 
                <c:forEach items="${applicationScope[ MENU_KEY ]}" var="entry">

                    <li class="layui-nav-item layui-nav-itemed">
                        <a class="" href="javascript:;">${ entry.value.menuName }</a>
                        <dl class="layui-nav-child">

                            <c:forEach items="${entry.value.menuItems}" var="item">
                                <c:if test="${item.visible==1}">
                                    <dd>
                                        <a href="#" onclick="gotoPage('${item.urlLink}');">
                                                ${item.itemName}
                                        </a>
                                    </dd>
                                </c:if>
                            </c:forEach>

                        </dl>
                    </li>

                </c:forEach>
 -->
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <iframe id="primaryWin" scrolling="no"
                frameborder="0"
                src="" ></iframe>
        <!-- 内容主体区域 -->
    </div>



    <div class="layui-footer">
        <!-- {Note} 底部固定区域 -->
        ALECTER.COM --- 艾力特信息技术有限公司
    </div>
</div>

<script src="${ctxPath}/layui/layui.js?t=1554901098009" charset="utf-8">
</script>

<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?d214947968792b839fd669a4decaaffc";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
</body>
</html>

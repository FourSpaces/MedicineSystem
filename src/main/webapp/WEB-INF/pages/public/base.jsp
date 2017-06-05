<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 17-2-25
  Time: 下午7:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="rapid"  uri="http://www.rapid-framework.org.cn/rapid"%>
<%@ include file="/WEB-INF/plugin/tab.jsp" %>
<html>
<head>
    <%@ include file="/WEB-INF/pages/public/headMeta.html" %>
    <title>
        <views:block name="title" />
    </title>
    <%@ include file="/WEB-INF/pages/public/headCssFile.html" %>
    <link rel="stylesheet" href="${__RES__}/css/public.css">

    <views:block name="page_css" />
</head>
<body>
<!-- 内容部分 -->
<div class="container-fluid">
    <div class="row">
        <!-- 载入导航模板 -->
        <views:block name="page_sidebar">
            <!-- 载入导航模板 -->
            <%@ include file="/WEB-INF/pages/public/nav.html" %>
            <%@ include file="/WEB-INF/pages/public/navSidebar.html" %>
        </views:block>


        <!-- 写入内容 Start -->
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <views:block name="page_content"/>
        </div>
        <!-- 写入内容 End -->
    </div>

</div>
<%@ include file="/WEB-INF/pages/public/publicScript.html" %>
<views:block name="page_script" />
</body>
</html>

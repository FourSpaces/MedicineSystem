<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 17-2-15
  Time: 上午5:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
    <%@ include file="../public/headMeta.html" %>
    <title>Title</title>
    <%@ include file="../public/headCssFile.html" %>
    <link rel="stylesheet" href="${__RES__}/css/public.css?1210974529">
</head>
<body>

<!-- 内容部分 -->
<div class="container-fluid">
    <div class="row">
        <!-- 载入导航模板 -->
        <%@ include file="../public/nav.html" %>
        <!-- 载入纵导航模板 -->
        <%@ include file="../public/navSidebar.html" %>
        <!-- 写入内容 Start -->
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

        <!-- 显示数据字典的表格 statr -->
            <div class="row">

                <div class="col-sm-10">
                    <h3>字典列表 <a href="${__ROOT__}/public/dictionary/add" type="button" class="btn btn-primary btn-sm">添加字段</a></h3>

                    <!-- 如果字典列表为空 -->
                    <c:if test="${empty dictionaryList}">
                        <div class="alert alert-warning" role="alert">
                            <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
                            字典表为空，请<a href="${__ROOT__}/public/dictionary/add" type="button" class="btn btn-primary btn-sm">添加</a>
                        </div>
                    </c:if>

                    <!-- 如果字典列表非空 -->
                    <c:if test="${!empty dictionaryList}">

                        <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>父级</th>

                            <th>字段名</th>
                            <th>字段值</th>

                            <th>创建时间</th>
                            <th>状态</th>
                            <th>操作</th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${dictionaryList}" var="dictionary">
                            <tr>
                                <td>${dictionary.id}</td>
                                <td>${dictionary.parent}</td>
                                <td>${dictionary.name}</td>
                                <td>${dictionary.value}</td>
                                <td>${dictionary.createTime}</td>
                                <td>${dictionary.status}</td>
                                <td>
                                    <a href="${__ROOT__}/public/dictionary/update/${dictionary.id}" type="button" class="btn btn-sm btn-warning">修改</a>
                                    <a href="${__ROOT__}/public/dictionary/delete/${dictionary.id}" type="button" class="btn btn-sm btn-danger">删除</a>
                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>

                    </c:if>
                </div>
            </div>

        <!-- 显示数据字典的表格 end -->

        </div>
        <!-- 写入内容 End -->
    </div>
</div>

<%@ include file="../public/publicScript.html" %>
</body>
</html>

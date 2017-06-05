<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 17-2-17
  Time: 上午2:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
    <%@ include file="../../public/headMeta.html" %>
    <title>Title</title>
    <%@ include file="../../public/headCssFile.html" %>
    <link rel="stylesheet" href="${__RES__}/css/public.css?${NOW_TIME}">
</head>
<body>

<!-- 内容部分 -->
<div class="container-fluid">
    <div class="row">
        <!-- 载入导航模板 -->
        <%@ include file="../../public/nav.html" %>
        <!-- 载入纵导航模板 -->
        <%@ include file="../../public/navSidebar.html" %>
        <!-- 写入内容 Start -->
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <!-- 显示数据字典的表格 statr -->
            <div class="row">

                <div class="col-sm-10">
                    <h3>员工列表 <a href="${__ROOT__}/admin/staff/add" type="button" class="btn btn-primary btn-sm">添加员工</a></h3>

                    <!-- 如果字典列表为空 -->
                    <c:if test="${empty staffInformationList}">
                        <div class="alert alert-warning" role="alert">
                            <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
                            员工列表为空，请<a href="${__ROOT__}/admin/staff/add" type="button" class="btn btn-primary btn-sm">添加</a>
                        </div>
                    </c:if>

                    <!-- 如果字典列表非空 -->
                    <c:if test="${!empty staffInformationList}">

                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>员工id</th>
                                <th>工号</th>
                                <th>部门</th>

                                <th>姓名</th>
                                <th>性别</th>
                                <th>手机/电话</th>

                                <th>工作类型</th>
                                <th>职称</th>
                                <th>编制</th>

                                <th>操作</th>

                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${staffInformationList}" var="staffInfo">
                                <tr>
                                    <td>${staffInfo.sid}</td>
                                    <td>${staffInfo.jobNumber}</td>
                                    <td>${dictionaryMap.get(staffInfo.department)}</td>

                                    <td>${staffInfo.name}</td>
                                    <td>${sexMap.get(staffInfo.sex)}</td>
                                    <td>${staffInfo.phone}</td>

                                    <td>${jobTypeMap.get(staffInfo.jobType)}</td>
                                    <td>${staffInfo.title}</td>
                                    <td>${organizationMap.get(staffInfo.organization)}</td>

                                    <td>
                                        <a href="${__ROOT__}/admin/staff/edit/${staffInfo.sid}" type="button" class="btn btn-sm btn-warning">修改</a>
                                        <a href="${__ROOT__}/admin/staff/delete/${staffInfo.sid}" type="button" class="btn btn-sm btn-danger">删除</a>
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

<%@ include file="../../public/publicScript.html" %>
</body>
</html>


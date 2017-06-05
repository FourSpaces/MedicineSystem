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
                    <h3>用户列表</h3>

                    <!-- 如果字典列表非空 -->
                    <c:if test="${!empty staffInformationList}">

                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>员工id</th>
                                <th>账号[ 工号 ]</th>
                                <th>工作类型</th>
                                <th>操作</th>

                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${staffInformationList}" var="staffInfo">
                                <tr>
                                    <td>${staffInfo.sid}</td>
                                    <td>${staffInfo.jobNumber}</td>
                                    <td>${jobTypeMap.get(staffInfo.jobType)}</td>
                                    <td>
                                        <a href="${__ROOT__}/public/aboutPassword/edit/${staffInfo.sid}" type="button" class="btn btn-sm btn-warning">修改</a>
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


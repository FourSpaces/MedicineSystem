<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 17-2-16
  Time: 上午11:34
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
    <link rel="stylesheet" href="${__RES__}/css/public.css?${NOW_TIME}">
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
            <div class="list-group">
                <span class="list-group-item active">
                    <h4 class="list-group-item-heading">
                        缴费管理-账单生成
                    </h4>
                </span>
                <span class="list-group-item">

                    <p class="list-group-item-text">
                        <table class="table table-bordered">
                            <tbody>
                                <tr>
                                    <td><b>收费id</b></td><td>${cost.cid}</td>
                                    <td><b>挂号id</b></td><td>${cost.rid}</td>
                                </tr>
                                <tr>
                                    <td><b>收费类型</b></td><td>
                                    <c:choose>
                                        <c:when test="${cost.costType == 1}">挂号</c:when>
                                        <c:when test="${cost.costType == 2}">检查</c:when>
                                        <c:when test="${cost.costType == 3}">药品</c:when>
                                        <c:when test="${cost.costType == 4}">住院费用</c:when>
                                        <c:when test="${cost.costType == 5}">住院预交费</c:when>
                                        <c:when test="${cost.costType == 6}">治疗费用</c:when>
                                        <c:otherwise>其他费用</c:otherwise>
                                    </c:choose>

                                    </td>
                                    <td><b>收费项目id</b></td><td>
                                    ${cost.receivableProject}
                                    </td>
                                </tr>
                                <tr>
                                    <td><b>应付款</b></td><td>${cost.receivable}</td>
                                    <td><b>付款状态</b></td><td>
                                     <c:choose>
                                         <c:when test="${cost.isReceivable == 1}">
                                            已收取
                                         </c:when>
                                         <c:otherwise>  <!--否则 -->
                                             未收取
                                         </c:otherwise>
                                     </c:choose>
                                </tr>
                                <tr>
                                    <td><b>创建时间</b></td><td>${cost.createTime}</td>
                                    <td><b></b></td><td></td>
                                </tr>

                            </tbody>
                        </table>
                    </p>
                </span>
            </div>


            <c:if test="${cost.isReceivable == 0}">
            <div class="list-group">
                <span href="#" class="list-group-item active">
                    <h4 class="list-group-item-heading">
                        缴费服务-收取费用
                    </h4>
                </span>
                <span href="#" class="list-group-item">
                    <h4 class="list-group-item-heading">
                        <div class="row">
                            <p class="col-sm-4">应缴费：${cost.receivable} 元人民币</p>
                            <div class="col-sm-2">
                            <form:form class="form-horizontal"  method="post" action="${__ROOT__}/public/cost/pay/${cost.cid}" commandName="pay" role="form">
                                <button class="btn btn-default input-sm" type="submit" >确认缴费</button>
                            </form:form>
                            </div>
                        </div>
                    </h4>

                </span>
            </div>
            </c:if>
        </div>
        <!-- 写入内容 End -->
    </div>
</div>

<%@ include file="../public/publicScript.html" %>
</body>
</html>

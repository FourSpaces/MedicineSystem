<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 17-3-4
  Time: 下午8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/plugin/tab.jsp" %>
<%--<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid"%>--%>

<views:override name="title" >${title}</views:override>

<views:override name="page_css"></views:override>

<views:override name="page_content">
    <!-- 显示数据字典的表格 statr -->
    <div class="row">

        <div class="col-sm-10">
            <h3>床位列表 <a href="${__ROOT__}/admin/bed/add" type="button" class="btn btn-primary btn-sm">添加床位</a></h3>

            <!-- 如果字典列表为空 -->
            <c:if test="${empty bedList}">
                <div class="alert alert-warning" role="alert">
                    <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
                    床位列表为空，请<a href="${__ROOT__}/admin/bed/add" type="button" class="btn btn-primary btn-sm">添加</a>
                </div>
            </c:if>

            <!-- 如果字典列表非空 -->
            <c:if test="${!empty bedList}">

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>床id</th>
                        <th>状态</th>
                        <th>操作</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${bedList}" var="medic">
                        <tr>
                            <td>${medic.id}</td>
                            <td>${medic.status}</td>

                            <td>
                                <a href="${__ROOT__}/admin/bed/delete/${medic.id}" type="button" class="btn btn-sm btn-danger">删除</a>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>

            </c:if>
        </div>
    </div>
    <!-- 显示数据字典的表格 end -->

</views:override>

<views:override name="page_script">
    <script>
        $(document).ready(function() {
            $(".select2").select2();
        });


    </script>
</views:override>

<%@include file="/WEB-INF/pages/public/base.jsp"%>

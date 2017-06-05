<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 2017/4/4
  Time: 14:37
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
            <h3>病人列表 </h3>

            <!-- 如果列表为空 -->
            <c:if test="${empty hospitalizedList}">
                <div class="alert alert-warning" role="alert">
                    <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
                    暂无病人
                </div>
            </c:if>

            <!-- 如果列表非空 -->
            <c:if test="${!empty hospitalizedList}">

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>住院id</th>
                        <th>挂号id</th>
                        <th>床位号</th>

                        <th>住院病因</th>
                        <th>入住时间</th>
                        <th>操作</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${hospitalizedList}" var="medic">
                        <tr>
                            <td>${medic.hid}</td>
                            <td>${medic.rid}</td>
                            <td>${medic.bedId}</td>

                            <td>${medic.pathogeny}</td>
                            <td><date:date value ="${medic.checkTime}"/></td>
                            <td>
                                <a href="${__ROOT__}/inpatient/diagnosis/${medic.hid}" type="button" class="btn btn-sm btn-warning">开药</a>
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

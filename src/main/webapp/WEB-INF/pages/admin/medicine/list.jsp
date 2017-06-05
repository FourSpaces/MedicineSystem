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
            <h3>药品列表 <a href="${__ROOT__}/admin/medicine/add" type="button" class="btn btn-primary btn-sm">添加药品</a></h3>

            <!-- 如果字典列表为空 -->
            <c:if test="${empty medicineList}">
                <div class="alert alert-warning" role="alert">
                    <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
                    药品列表为空，请<a href="${__ROOT__}/admin/medicine/add" type="button" class="btn btn-primary btn-sm">添加</a>
                </div>
            </c:if>

            <!-- 如果字典列表非空 -->
            <c:if test="${!empty medicineList}">

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>药品id</th>
                        <th>药品名称</th>

                        <th>单位</th>
                        <th>价格</th>

                        <th>备注</th>
                        <th>状态</th>

                        <th>操作</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${medicineList}" var="medic">
                        <tr>
                            <td>${medic.mid}</td>
                            <td>${medic.name}</td>

                            <td>${medic.unit}</td>
                            <td>${medic.price}</td>

                            <td>${medic.remark}</td>
                            <td>${medic.status}</td>

                            <td>
                                <a href="${__ROOT__}/admin/medicine/edit/${medic.mid}" type="button" class="btn btn-sm btn-warning">修改</a>
                                <a href="${__ROOT__}/admin/medicine/delete/${medic.mid}" type="button" class="btn btn-sm btn-danger">删除</a>
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

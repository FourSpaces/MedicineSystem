<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 17-2-27
  Time: 下午9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/plugin/tab.jsp" %>
<%--<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid"%>--%>

<views:override name="title" >${title}</views:override>

<views:override name="page_css">
    <style>
        textarea {
            width:360px;
            height:100px;
        }
    </style>
</views:override>

<views:override name="page_content">
    <div class="row">
        <!-- 验证挂号信息与科室 -->
        <div class="col-lg-4">
                <%-- 验证用户账号真实性 start--%>
            <div id="" class="">
                <legend class=""><h4>验证挂号信息</h4></legend>
            </div>
            <div class="row">
                <div class="col-lg-8">
                    <form:form class="form-horizontal"  method="get" action="${__ROOT__}/public/chemist" commandName="diagnosis" role="form">
                        <div class="input-group">
                            <input type="text" class="form-control input-sm" name="rid" placeholder="挂号单编号" value="${rid}">
                            <span class="input-group-btn">
                                <button class="btn btn-default input-sm" type="submit" >验证</button>
                            </span>
                        </div><!-- /input-group -->
                    </form:form>
                </div><!-- /.col-lg-6 -->
                <br>
            </div><!-- /.row -->
                <%-- 验证用户账号真实性 end--%>
            <!-- 临床挂号 -->
            <div class="row">
                <div class="col-lg-8"><br>
                    <!-- 信息展示 -->
                    <div class="list-group">
                        <span class="list-group-item active">
                            <h5 class="list-group-item-heading">
                                取药信息
                            </h5>
                        </span>
                        <span class="list-group-item">
                            <p class="list-group-item-text">
                                缴费状态：
                                <c:choose>
                                    <c:when test="${cost.isReceivable == 1}">
                                        <span style="color:green;">已收取</span>
                                    </c:when>
                                    <c:when test="${cost.isReceivable == 0}">
                                        <span style="color: red;">未收取</span>
                                    </c:when>
                                </c:choose>
                            </p>
                            <p class="list-group-item-text">
                                取药状态：
                                <c:choose>
                                    <c:when test="${cost.status == 3}">
                                        <span style="color: red;">已取药</span>
                                    </c:when>
                                    <c:when test="${cost.status == 1}">
                                        <span style="color: green;">未取药</span>
                                    </c:when>
                                </c:choose>
                            </p>
                        </span>

                    </div>
                </div>
            </div>
        </div>


        <!-- 如果用户信息不为空 -->
        <c:if test="${!empty cost}">
            <!-- 诊断 -->
            <div class="col-lg-6">
                <div id="" class="">
                    <legend class=""><h4>药品详情</h4></legend>
                </div>

                    <div class="col-sm-10">
                        <!-- BOX -->
                        <div class="box border blue">
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-10" id="drugsList"  style="font-size: 12px;">
                                        <table  class="table table-striped ">
                                            <thead>
                                            <tr>
                                                <th>药品名称</th>
                                                <th>数量</th>
                                            </tr>
                                            </thead>
                                            <tbody >
                                            </tbody>
                                        </table>

                                    </div>
                                </div>
                                <div>
                                    <c:choose>
                                        <c:when test="${cost.status == 1 and cost.isReceivable == 1}">
                                            <button id="getMedic" class="btn btn-primary">取药</button>
                                        </c:when>
                                    </c:choose>

                                </div>
                            </div>
                        </div>
                        <!-- /BOX -->
                    </div>

            </div>
        </c:if>
    </div>
</views:override>

<views:override name="page_script">
    <script  type="text/javascript" src="${__RES__}/js/jquery.table-json.conversion.js" ></script>
    <script>
        $(document).ready(function() {
            //生成JSON
            //var jsonlist1 = JSON.parse('${cost.remark});
            var jsonlist1 = ${cost.remark};
            var jsonTable = [];

            for(var i in jsonlist1){
                var del = "<a class='deltr' data-id='"+i+"' >删除</a>";
                var jt = {"#":i ,"药品名称":jsonlist1[i].name, "数量":jsonlist1[i].total};
                jsonTable.push(jt);
            }

            //列表
            $("#drugsList").html('');

            //生成表格
            $.jsonToTable(jsonTable, { id: "#drugsList",header: true, className: "table table-striped"});

        });

        //添加取药品完成事件
        $("#getMedic").on("click", function(){

            $.get("/api/chemist/take/${cost.cid}",function(data,status){
                alert("数据: " + data + "\n状态: " + status);
                //window.location.href="/public/Chemist";
            });
            setTimeout(function(){window.location.href="/public/chemist?rid=${rid}";},800);

        });

    </script>
</views:override>

<%@include file="/WEB-INF/pages/public/base.jsp"%>

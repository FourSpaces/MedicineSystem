<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 17-2-14
  Time: 上午2:05
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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



        </div>
        <!-- 写入内容 End -->
    </div>
</div>

<%@ include file="../public/publicScript.html" %>

<script>


</script>
</body>
</html>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/plugin/tab.jsp" %>
<%--<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid"%>--%>

<views:override name="title" >${title}</views:override>

<views:override name="page_css">
    <style>
        textarea {
            width: 360px;
            height: 100px;
        }
    </style>
</views:override>

<views:override name="page_content">
    <div class="row">

        <div class="col-lg-6">
                <%-- 验证用户账号真实性 start--%>
            <div id="" class="">
                <legend class=""><h4>验证用户账号</h4></legend>
            </div>
            <div class="row">
                <div class="col-lg-8">
                    <form:form class="form-horizontal"  method="get" action="${__ROOT__}/clinic/registration/" commandName="phone" role="form">
                        <div class="input-group">
                            <input type="text" class="form-control input-sm" name="phone" placeholder="请输入手机号" value="${phone}">
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
                    <!-- 个人信息展示 -->
                    <div class="list-group">
                        <span class="list-group-item active">
                            <h5 class="list-group-item-heading">
                                个人信息
                            </h5>
                        </span>
                                <span class="list-group-item">
                            <p class="list-group-item-text">
                                姓名：${userInfos.name}
                            </p>
                            <p class="list-group-item-text">
                                性别：
                                <c:choose>
                                    <c:when test="${userInfos.sex == 1}">
                                        男
                                    </c:when>
                                    <c:otherwise>  <!--否则 -->
                                        女
                                    </c:otherwise>
                                </c:choose>
                            </p>
                            <p class="list-group-item-text">
                                身份证号：${userInfos.idCard}
                            </p>
                            <p class="list-group-item-text">
                                 现住址：${userInfos.address}
                            </p>
                            <p class="list-group-item-text">
                                状态：${userInfos.status}
                            </p>
                        </span>

                    </div>
                </div>
            </div>
        </div>

        <!-- 如果用户信息为空 -->
        <c:if test="${empty userInfos}">


            <div class="col-lg-6">
                <!-- 添加基本数据 -->
                <div id="" class="">
                    <legend class=""><h4>编辑用户信息</h4></legend>
                </div>
                <form:form class="form-horizontal"  method="post" action="${__ROOT__}/public/addUser" commandName="user" role="form">
                    <fieldset>
                        <div class="form-group">
                            <!-- Text input-->
                            <label class="col-sm-3 control-label" for="usernames">名字</label>
                            <div class="col-sm-9 controls">
                                <input placeholder="请输入名字" class="input-sm" id="usernames" name="name" type="text">
                            </div>
                        </div>

                        <div class="form-group">
                            <!-- Select Basic -->
                            <label class="col-sm-3 control-label" for="usersexs">性别</label>
                            <div class="col-sm-9 controls">
                                <select class="input-sm" id="usersexs" name="sex">
                                    <option value="1">男</option>
                                    <option value="2">女</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <!-- Text input-->
                            <label class="col-sm-3 control-label" for="userbirthdays">生日</label>
                            <div class="col-sm-9 controls">
                                <input type="date" class="input-sm" id="userbirthdays" name="birthday" >
                            </div>
                        </div>

                        <div class="form-group">
                            <!-- Text input-->
                            <label class="col-sm-3 control-label" for="userphones">手机号</label>
                            <div class="col-sm-9 controls">
                                <input placeholder="请输入手机号" id="userphones"  name="phone" class="input-sm" type="text">
                            </div>
                        </div>

                        <div class="form-group">
                            <!-- Text input-->
                            <label class="col-sm-3 control-label" for="userid_cards">身份证号</label>
                            <div class="col-sm-9 controls">
                                <input placeholder="请输入身份证号" id="userid_cards" name="idCard" class="input-sm" type="text">
                                <p class="help-block"></p>
                            </div>
                        </div>

                        <div class="form-group">
                            <!-- Text input-->
                            <label class="col-sm-3 control-label" for="useraddresss">现住址</label>
                            <div class="col-sm-9 controls">
                                <input placeholder="请输入住址" id="useraddresss" name="address" class="input-sm" type="text">
                            </div>
                        </div>

                        <div class="form-group">
                            <!-- Textarea -->
                            <label class="col-sm-3 control-label" for="userremarks">备注</label>
                            <div class="col-sm-9 controls">
                                <div class="textarea">
                                    <textarea type="" class="" id="userremarks" name="remark"></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default input-sm">提交</button>
                            </div>
                        </div>
                    </fieldset>
                </form:form>
            </div><!-- /.col-lg-6 -->
        </c:if>

        <!-- 如果用户信息不为空 -->
        <c:if test="${!empty userInfos}">
            <!-- 临床挂号 -->
            <div class="col-lg-6">
                <div id="" class="">
                    <legend class=""><h4>用户挂号</h4></legend>
                </div>

                <form:form class="form-horizontal"  method="post" action="${__ROOT__}/clinic/registration" commandName="registration" role="form">
                    <fieldset>
                        <div class="form-group">
                            <!-- Text input-->
                            <label class="col-sm-3 control-label" for="ghname">名字</label>
                            <div class="col-sm-9 controls">
                                <input placeholder="请输入名字" class="input-sm" id="ghname" name="name" type="text" value="${userInfos.name}">
                            </div>
                        </div>

                        <div class="form-group">
                            <!-- Select Basic -->
                            <label class="col-sm-3 control-label" for="reservation_department">预约科室</label>
                            <div class="col-sm-9 controls">

                                <select class="input-sm" id="reservation_department" name="reservationDepartment">
                                    <option value="0">--请选择--</option>
                                    <c:forEach items="${dictionaryList}" var="dictionary">
                                        <option value="${dictionary.id}">${dictionary.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <!-- Select Basic -->
                            <label class="col-sm-3 control-label" for="reservation_doctor">预约医生</label>
                            <div class="col-sm-9 controls">
                                <select class="input-sm" id="reservation_doctor" name="reservationDoctor">
                                    <option value="0">--请选择科室--</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <!-- Text input-->
                            <label class="col-sm-3 control-label" for="reservation_cost">预约费用</label>
                            <div class="col-sm-9 controls">
                                <input type="text" class="input-sm" id="reservation_cost" name="reservationCost" value="10" >
                            </div>
                        </div>

                        <div class="form-group">
                            <!-- Textarea -->
                            <label class="col-sm-3 control-label" for="remark">备注</label>
                            <div class="col-sm-9 controls">
                                <div class="textarea">
                                    <textarea type="" class="" id="remark" name="remark"></textarea>
                                </div>
                            </div>
                        </div>

                        <!-- 把 id 一并写入  -->
                        <input type="hidden" name="uid" value="${userInfos.uid}"/>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default input-sm">提交</button>
                            </div>
                        </div>
                    </fieldset>
                </form:form>


            </div><!-- /.col-lg-6 -->
        </c:if>
    </div><!-- /.row -->
    <%-- 验证用户账号真实性 end--%>
</views:override>

<views:override name="page_script">
    <script  type="text/javascript" src="${__RES__}/js/jquery.table-json.conversion.js" ></script>
    <script>
        $(document).ready(function() {
            $(".select2").select2();
        });

        //选择科室发生改变时
        $("#reservation_department").change(function(){
            // 先清空第二个
            $("#reservation_doctor").empty();

            //获得当前值
            var jobtype = $(this).val();

            $.get("/api/staff/info/1/"+jobtype,function(data,status){
                for(jsonObj in data){
                    var option = $("<option>").val(data[jsonObj].sid).text(data[jsonObj].name);
                    $("#reservation_doctor").append(option);
                }
            });
            // 实际的应用中，这里的option一般都是用循环生成多个了

        });

    </script>
</views:override>

<%@include file="/WEB-INF/pages/public/base.jsp"%>

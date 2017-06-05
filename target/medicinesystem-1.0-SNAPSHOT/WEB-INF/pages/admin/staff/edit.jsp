<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 17-2-17
  Time: 上午4:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/plugin/tab.jsp" %>

<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
    <%@ include file="../../public/headMeta.html" %>
    <title>Title</title>
    <%@ include file="../../public/headCssFile.html" %>
    <link rel="stylesheet" href="${__RES__}/css/public.css?1210974529">
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

            <div class="row">

                <!-- 编辑工作人员 -->
                <div class="col-lg-6">
                    <!-- 添加基本数据 -->
                    <div id="" class="">
                        <legend class=""><h4>编辑员工信息</h4></legend>
                    </div>

                    <form:form action="${__ROOT__}/admin/staff/${editPage}" class="form-horizontal"  method="post"  commandName="staff" role="form">

                        <input type="hidden" name="sid" value="${staffInformation.sid}"/>
                        <fieldset>
                            <div class="form-group">
                                <!-- Text input-->
                                <label class="col-sm-3 control-label" for="usernames">名字</label>
                                <div class="col-sm-9 controls">
                                    <input placeholder="请输入名字" class="input-sm" id="usernames" name="name" type="text" value="${staffInformation.name}" >
                                </div>
                            </div>

                            <div class="form-group">
                                <!-- Select Basic -->
                                <label class="col-sm-3 control-label" for="usersexs">性别</label>
                                <div class="col-sm-9 controls">
                                    <select class="input-sm" id="usersexs" name="sex">
                                        <option value="1"  <c:if test="${staffInformation.sex == 1} ">selected="true"</c:if> >男</option>
                                        <option value="2"  <c:if test="${staffInformation.sex == 2}">selected="true"</c:if> >女</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <!-- Text input-->
                                <label class="col-sm-3 control-label" for="userphones">手机号</label>
                                <div class="col-sm-9 controls">
                                    <input placeholder="请输入手机号" id="userphones"  name="phone" class="input-sm" type="text" value="${staffInformation.phone}" >
                                </div>
                            </div>

                            <div class="form-group">
                                <!-- Text input-->
                                <label class="col-sm-3 control-label" for="userid_cards">身份证号</label>
                                <div class="col-sm-9 controls">
                                    <input placeholder="请输入身份证号" id="userid_cards" name="idCard" class="input-sm" type="text" value="${staffInformation.idCard}" >
                                    <p class="help-block"></p>
                                </div>
                            </div>

                            <div class="form-group">
                                <!-- Text input-->
                                <label class="col-sm-3 control-label" for="useraddresss">现住址</label>
                                <div class="col-sm-9 controls">
                                    <input placeholder="请输入住址" id="useraddresss" name="address" class="input-sm" type="text" value="${staffInformation.address}" >
                                </div>
                            </div>

                            <div class="form-group">
                                <!-- Text input-->
                                <label class="col-sm-3 control-label" for="jobNumber">工号</label>
                                <div class="col-sm-9 controls">
                                    <input type="text" class="input-sm" id="jobNumber" name="jobNumber" value="${staffInformation.jobNumber}" >
                                </div>
                            </div>

                            <div class="form-group">
                                <!-- Select Basic -->
                                <label class="col-sm-3 control-label" for="reservation_department">所属部门 ${staffInformation.department} </label>
                                <div class="col-sm-9 controls">
                                    <select class="input-sm" id="reservation_department" name="department">
                                        <c:forEach items="${dictionaryList}" var="dictionary">
                                            <option value="${dictionary.id}" <c:if test="${staffInformation.department == dictionary.id}">selected="true"</c:if> >${dictionary.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <!-- Select Basic -->
                                <label class="col-sm-3 control-label" for="jobTypes">工作分类</label>
                                <div class="col-sm-9 controls">
                                    <select class="input-sm" id="jobTypes" name="jobType">
                                        <option value="1" <c:if test="${staffInformation.jobType == 1}">selected="true"</c:if> >门诊部医生</option>
                                        <option value="2" <c:if test="${staffInformation.jobType == 2}">selected="true"</c:if> >门诊部护士</option>
                                        <option value="3" <c:if test="${staffInformation.jobType == 3}">selected="true"</c:if> >工作人员</option>
                                        <option value="4" <c:if test="${staffInformation.jobType == 4}">selected="true"</c:if> >住院部医生</option>
                                        <option value="5" <c:if test="${staffInformation.jobType == 5}">selected="true"</c:if> >住院部护士</option>
                                        <option value="6" <c:if test="${staffInformation.jobType == 6}">selected="true"</c:if> >系统管理员</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <!-- Text input-->
                                <label class="col-sm-3 control-label" for="userid_cards">职称</label>
                                <div class="col-sm-9 controls">
                                    <input placeholder="请输入职称" id="titles" name="title" class="input-sm" type="text" value="${staffInformation.title}" >
                                    <p class="help-block"></p>
                                </div>
                            </div>

                            <div class="form-group">
                                <!-- Select Basic -->
                                <label class="col-sm-3 control-label" for="organizations">编制</label>
                                <div class="col-sm-9 controls">
                                    <select class="input-sm" id="organizations" name="organization">
                                        <option value="1" <c:if test="${staffInformation.organization == 1}">selected="true"</c:if> >有编制</option>
                                        <option value="2" <c:if test="${staffInformation.organization == 2}">selected="true"</c:if> >临时工</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <!-- Text input-->
                                <label class="col-sm-3 control-label" for="induction_time">入职时间</label>
                                <div class="col-sm-9 controls">
                                    <input type="date" class="input-sm" id="induction_time"  value="<date:date value ="${staffInformation.inductionTime} "/>" >
                                    <input type="hidden" class="input-sm" id="induction_time_s" name="inductionTime" value="${staffInformation.inductionTime}" >
                                </div>
                            </div>

                            <div class="form-group">
                                <!-- Text input-->
                                <label class="col-sm-3 control-label" for="departure_time">离职时间</label>
                                <div class="col-sm-9 controls">
                                    <input type="date" class="input-sm" id="departure_time" value="<date:date value ="${staffInformation.departureTime} "/>" >
                                    <input type="hidden" class="input-sm" id="departure_time_s" name="departureTime" value="${staffInformation.departureTime}" >
                                </div>
                            </div>

                            <div class="form-group">
                                <!-- Textarea -->
                                <label class="col-sm-3 control-label" for="userremarks">备注</label>
                                <div class="col-sm-9 controls">
                                    <div class="textarea">
                                        <textarea type="" class="" id="userremarks" name="remark">${staffInformation.remark}</textarea>
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


            </div><!-- /.row -->
            <%-- 验证用户账号真实性 end--%>

        </div>
        <!-- 写入内容 End -->
    </div>
</div>

<%@ include file="../../public/publicScript.html" %>
<script>

    $("form").submit(function(e){
        $("input[type='date']").each(function(){
            var eacho = $(this).val();
            //获得当前数据
            if(eacho !=""){
                var timestamp = Date.parse(new Date(eacho));
                timestamp = timestamp / 1000;
                var ipnutid = $(this).attr("id");
                $("#"+ipnutid+"_s").val(timestamp);
            }
        });
    });
</script>
</body>
</html>

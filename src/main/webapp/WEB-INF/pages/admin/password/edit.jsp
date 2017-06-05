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

                    <form:form action="${__ROOT__}/public/aboutPassword/${editPage}" class="form-horizontal"  method="post"  commandName="staff" role="form">

                        <input type="hidden" name="sid" value="${staffInformation.sid}"/>
                        <fieldset>

                            <div class="form-group">
                                <!-- Text input-->
                                <label class="col-sm-3 control-label" for="password1">请输入密码</label>
                                <div class="col-sm-9 controls">
                                    <input placeholder="请输入密码" id="password1" name="password" class="input-sm" type="text" value="" >
                                    <p class="help-block"></p>
                                </div>
                            </div>
                            <div class="form-group">
                                <!-- Text input-->
                                <label class="col-sm-3 control-label" for="password2">请再次输入</label>
                                <div class="col-sm-9 controls">
                                    <input placeholder="请输入密码" id="password2" class="input-sm" type="text" value="" >
                                    <p class="help-block"></p>
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
<script type="text/javascript">
    $(document).ready(function(){
        $("form").submit(function(e){

            var password1 = $("#password1").val();
            var password2 = $("#password2").val();

            if(password1 != password2){
                e.preventDefault();
                alert("两次密码输入不一致，请重新输入");
            }
        });
    });
</script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 2017/4/1
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>医药管理系统 | 登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- STYLESHEETS --><!--[if lt IE 9]>
    <script src="${__RES__}/js/flot/excanvas.min.js"></script>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->

    <link rel="stylesheet" type="text/css" href="${__RES__}/css/cloud-admin.css" >

    <link href="${__RES__}/css/font-awesome.min.css" rel="stylesheet">
    <!-- DATE RANGE PICKER -->
    <link rel="stylesheet" type="text/css" href="${__RES__}/css/daterangepicker-bs3.css" />
    <!-- UNIFORM -->
    <link rel="stylesheet" type="text/css" href="${__RES__}/css/uniform.default.min.css" />
    <!-- ANIMATE -->
    <link rel="stylesheet" type="text/css" href="${__RES__}/css/animatecss/animate.min.css" />
    <!-- FONTS -->

</head>
<body class="login">
<!-- PAGE -->
<section id="page">
    <!--/HEADER -->
    <!-- LOGIN -->
    <section id="login" class="visible">
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="alert alert-block alert-danger fade">
                        <a class="close" data-dismiss="alert" href="#" aria-hidden="true">×</a>
                        <h4><i class="fa fa-times"></i>
                            <span id="Alerts">登录失败，请检查用户名和密码</span>
                        </h4>
                    </div>
                    <div class="login-box-plain">
                        <h2 class="bigintro">登录</h2>
                        <div class="divide-40"></div>
                        <form:form action="${__ROOT__}/login" class="form-horizontal"  method="post"  commandName="user" role="form">

                            <div class="form-group">
                                <label for="username">用户名</label>
                                <i class="fa fa-envelope"></i>
                                <input type="text" class="form-control" id="username"  name="jobNumber">
                            </div>
                            <div class="form-group">
                                <label for="password">密码</label>
                                <i class="fa fa-lock"></i>
                                <input type="password" class="form-control" id="password"  name="password" >
                            </div>
                            <div class="form-actions">
                                <%--<label class="checkbox"> <input type="checkbox" class="uniform" value=""> 记住我</label>--%>
                                <button type="submit" class="btn btn-default ">登录</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--/LOGIN -->
</section>
<!--/PAGE -->
<!-- JAVASCRIPTS -->
<!-- Placed at the end of the document so the pages load faster -->
<!-- JQUERY -->
<script type="text/javascript" src="${__RES__}/js/jquery.min.js"></script>
<!-- JQUERY UI-->
<script type="text/javascript" src="${__RES__}/js/jquery-ui-1.10.3.custom.min.js"></script>
<!-- BOOTSTRAP -->
<script type="text/javascript" src="${__RES__}/bootstrap/js/bootstrap.min.js"></script>

<!-- UNIFORM -->
<script type="text/javascript" src="${__RES__}/js/jquery.uniform.min.js"></script>
<!-- CUSTOM SCRIPT -->
<%--<script src="${__RES__}/js/script.js"></script>--%>
<script>

    $(document).ready(function(){
        //获取url中的参数
        function getUrlParam(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
            var r = window.location.search.substr(1).match(reg);  //匹配目标参数
            if (r != null) return unescape(r[2]); return null; //返回参数值
        }

        var tabValue =  getUrlParam("tab");
        if(tabValue!= null){
            $(".alert").addClass("in");
        }
        $("form").submit(function(e){

            var username = $("#username").val();
            var password = $("#password").val();

            if(username == "" || password == ""){
                e.preventDefault();
                alert("用户名或密码不能为空，请重新输入！");
            }
        });
    });
</script>
<script type="text/javascript">
/*    function swapScreen(id) {
        jQuery('.visible').removeClass('visible animated fadeInUp');
        jQuery('#'+id).addClass('visible animated fadeInUp');
    }*/
</script>
<!-- /JAVASCRIPTS -->
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 17-2-13
  Time: 下午11:36
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
    <div class="row">
        <div class="col-md-8">
            <!-- BOX -->
            <div class="box ">
                <div class="box-title">
                    <h4><i class="fa fa-book"></i>欢迎页面</h4>
                </div>
                <div class="box-body font-400">
                    <div class="row">
                        <div class="col-xs-12">
                            <blockquote class="pull-right">
                                <p>欢迎 ${userInfo.name} 登录！</p>
                            </blockquote>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /BOX -->
        </div>
    </div>
</views:override>

<views:override name="page_script">

</views:override>

<%@include file="/WEB-INF/pages/public/base.jsp"%>

<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 17-2-15
  Time: 上午5:59
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
            <div class="row">
                <!-- 添加基本数据 -->
                <div class="col-lg-6">
                    <form:form class="form-horizontal"  method="post" action="${__ROOT__}/public/dictionary/add" commandName="dictionary" role="form">
                        <fieldset>
                            <div id="legend" class="">
                                <legend class="">数据字典【添加】</legend>
                            </div>

                            <div class="form-group">
                                <!-- Text input-->
                                <label class="col-sm-3 control-label" for="parent">字典父级</label>
                                <div class="col-sm-9 controls">
                                    <select class="input-sm" id="parent" name="parent">
                                        <option value="0">无父级</option>
                                        <c:forEach items="${dictionaryList}" var="dictionary">
                                            <option value="${dictionary.id}">${dictionary.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <!-- Select Basic -->
                                <label class="col-sm-3 control-label" for="names">字段名字</label>
                                <div class="col-sm-9 controls">
                                    <input type="text" class="input-sm" id="names" name="name" >
                                </div>
                            </div>

                            <div class="form-group">
                                <!-- Text input-->
                                <label class="col-sm-3 control-label" for="values">字段值</label>
                                <div class="col-sm-9 controls">
                                    <input type="date" class="input-sm" id="values" name="value" >
                                </div>
                            </div>

                            <div class="form-group">
                                <!-- Text input-->
                                <label class="col-sm-3 control-label" for="detailss">字段详情</label>
                                <div class="col-sm-9 controls">
                                    <div class="textarea">
                                        <textarea type="" class="" id="detailss" name="details"></textarea>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <!-- Text input-->
                                <label class="col-sm-3 control-label" for="remarks">备注</label>
                                <div class="col-sm-9 controls">
                                    <div class="textarea">
                                        <textarea type="" class="" id="remarks" name="remark"></textarea>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <!-- Text input-->
                                <label class="col-sm-3 control-label" for="statuss">状态</label>
                                <div class="col-sm-9 controls">
                                    <input placeholder="" id="statuss"  name="status" class="input-sm" type="text" value="1">
                                </div>
                            </div>

                            <div class="form-group">
                                <!-- Text input-->
                                <label class="col-sm-3 control-label" for="sorts">排序</label>
                                <div class="col-sm-9 controls">
                                    <input placeholder="" id="sorts" name="sort" class="input-sm" type="text" value="0">
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
            </div>
        </div>
        <!-- 写入内容 End -->
    </div>
</div>

<%@ include file="../public/publicScript.html" %>
</body>
</html>

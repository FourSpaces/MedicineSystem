<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 17-2-27
  Time: 下午9:45
  To change this template use File | Settings | File Templates.
，--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/plugin/tab.jsp" %>
<!-- 载入对应的文件 -->
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%--<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid"%>--%>
<%!
    //这里编写公共方法
        /*
     * 将时间戳转换为时间
     */
    String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
%>

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
                <legend class=""><h4>用户信息验证</h4></legend>
            </div>
            <div class="row">
                <div class="col-lg-10">
                <div class="panel-group" id="accordion">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">
                                <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">住院ID验证</a> </h3>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse" style="height: 0px;">
                            <div class="panel-body">
                                <form:form class="form-horizontal"  method="get" action="${__ROOT__}/inpatient/index/" commandName="diagnosis" role="form">
                                    <div class="input-group">
                                        <input type="text" class="form-control input-sm" name="hid" placeholder="住院ID" value="${hid}">
                                        <span class="input-group-btn">
                                            <button class="btn btn-default input-sm" type="submit" >验证</button>
                                        </span>
                                    </div><!-- /input-group -->
                                </form:form>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title"> <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">挂号ID验证 </a> </h3>
                        </div>
                        <div id="collapseTwo" class="panel-collapse in" style="height: auto;">
                            <div class="panel-body">
                                <form:form class="form-horizontal"  method="get" action="${__ROOT__}/inpatient/index/" commandName="diagnosis" role="form">
                                    <div class="input-group">
                                        <input type="text" class="form-control input-sm" name="rid" placeholder="挂号ID" value="${rid}">
                                        <span class="input-group-btn">
                                            <button class="btn btn-default input-sm" type="submit" >验证</button>
                                        </span>
                                    </div><!-- /input-group -->
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
                </div><!-- /.col-lg-10 -->
                <br>
            </div><!-- /.row -->
                <%-- 验证用户账号真实性 end--%>

            <!-- 给出用户的诊断信息 -->
            <c:if test="${!empty diagnosis}">
                <div class="row">
                    <div class="col-lg-10"><br>
                        <!-- 信息展示 -->
                        <div class="list-group">
                        <span class="list-group-item active">
                            <h5 class="list-group-item-heading">
                                诊断信息
                            </h5>
                        </span>
                        <span class="list-group-item">
                            <p class="list-group-item-text">
                                病情描述：${diagnosis.describes}
                            </p>
                            <p class="list-group-item-text">
                                处理结果：
                                <c:choose>
                                    <c:when test="${diagnosis.resolvent == 1}">
                                        <span style="color: red;">开药</span>
                                    </c:when>
                                    <c:when test="${diagnosis.resolvent == 2}">
                                        <span style="color: green;">住院</span>
                                    </c:when>
                                </c:choose>
                            </p>
                        </span>

                        </div>
                    </div>
                </div>
            </c:if>

            <c:if test="${empty diagnosis  }">
                <div class="row">
                    <div class="col-lg-10"><br>
                        <!-- 信息展示 -->
                        <div class="list-group">
                <span class="list-group-item active">
                    <h5 class="list-group-item-heading">
                        提示信息
                    </h5>
                </span>
                <span class="list-group-item">
                    <p class="list-group-item-text">
                        无诊断数据
                    </p>
                </span>

                        </div>
                    </div>
                </div>
            </c:if>
        </div>


        <!-- 如果住院信息不存在 -->
        <c:if test ="${empty hospitalized }">
            <div  class="col-lg-8" >
                <div>
                    <legend ><h4>住院服务</h4></legend>
                </div>
                <div class="row" >
                    <ul id="myTab" class="nav nav-tabs">
                        <li class="active"><a href="#home" data-toggle="tab">住院手续办理</a>
                        </li>
                    </ul>
                    <div id="myTabContent" class="tab-content">
                        <div class="tab-pane fade in active" id="home">
                            <div class="box border pink">
                                <div class="box-body big">
                                <form:form class="form-horizontal"  method="post" action="${__ROOT__}/inpatient/create" commandName="registration" role="form">
                                    <fieldset>
                                        <div class="form-group">
                                            <!-- Text input-->
                                            <label class="col-sm-3 control-label" for="irid">挂号id</label>
                                            <div class="col-sm-9 controls">
                                                <input placeholder="挂号id" class="input-sm" id="irid" name="rid" type="text" value="${diagnosis.rid}">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <!-- Select Basic -->
                                            <label class="col-sm-3 control-label" for="reservation_department">科室</label>
                                            <div class="col-sm-9 controls">
                                                <input name="department" type="hidden" value="${reservation.reservationDepartment}">

                                                <c:forEach items="${dictionaryList}" var="dictionary">
                                                        <%--<option value="${dictionary.id}">${dictionary.name}</option>--%>
                                                        <c:if test="${dictionary.id == reservation.reservationDepartment}"  >
                                                            <input placeholder="挂号id" class="input-sm" id="reservation_department"type="text" value="${dictionary.name}"  >
                                                        </c:if>
                                                </c:forEach>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <!-- Select Basic -->
                                            <label class="col-sm-3 control-label" for="reservation_">责任医生</label>
                                            <div class="col-sm-9 controls">
                                                <select class="input-sm" id="reservation_" name="sid">
                                                    <option value="0">--请选择医师--</option>
                                                   <%-- staffinfoList--%>
                                                    <c:forEach items="${staffinfoList}" var="dictionary">
                                                        <option value="${dictionary.sid}">${dictionary.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <!-- Select Basic -->
                                            <label class="col-sm-3 control-label" for="chuangwei">选择床位</label>
                                            <div class="col-sm-9 controls">
                                                <select class="input-sm" id="chuangwei" name="bedid">
                                                    <c:forEach items="${bedList}" var="dictionary">
                                                        <option value="${dictionary.id}">${dictionary.id}号床</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <!-- Text input-->
                                            <label class="col-sm-3 control-label" for="reservation_cost">费用</label>
                                            <div class="col-sm-9 controls">
                                                <input type="text" class="input-sm" id="reservation_cost" name="costValue" value="200" >
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

                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button type="submit" class="btn btn-default input-sm">提交</button>
                                            </div>
                                        </div>
                                    </fieldset>
                                </form:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>

        <!-- 如果住院信息存在 -->
        <c:if test ="${!empty hospitalized && !empty diagnosis }">
            <div  class="col-lg-8" >
                <div>
                    <legend ><h4>住院服务</h4></legend>
                </div>
                <div class="row" >
                    <ul id="myTab" class="nav nav-tabs">
                        <li class="active"><a href="#home" data-toggle="tab">住院详情</a></li>
                        <c:if test="${hospitalized.status == 1}" >
                            <li class=""><a href="#cysx" data-toggle="tab">出院手续办理</a></li>
                        </c:if>
                       <%-- <c:if test="${hospitalized.status == 1}" >
                            <li class=""><a href="#yjfy" data-toggle="tab">预缴费</a></li>
                        </c:if>--%>

                    </ul>
                    <div id="myTabContent" class="tab-content">
                        <div class="tab-pane fade in active" id="home">
                            <div class="row">
                                <div class="col-lg-10"><br>
                                    <!-- 信息展示 -->
                                    <div class="box border pink">
                                        <div class="box-body big">
                                            <h4>姓名：${userInfos.name}</h4>
                                            <h4>性别：
                                                <c:choose>
                                                    <c:when test="${userInfos.sex == 1}">
                                                        男
                                                    </c:when>
                                                    <c:when test="${userInfos.sex == 2}">
                                                        女
                                                    </c:when>
                                                </c:choose>
                                            </h4>
                                            <h4>住院id: ${hospitalized.hid}</h4>
                                            <h4>挂号id: ${hospitalized.rid}</h4>
                                            <h4>责任医师:
                                                <c:forEach items="${dictionaryList}" var="dictionary">
                                                    <%--<option value="${dictionary.id}">${dictionary.name}</option>--%>
                                                    <c:if test="${dictionary.id == hospitalized.department}"  >
                                                        ${dictionary.name}
                                                    </c:if>
                                                </c:forEach>
                                                <c:forEach items="${staffinfoList}" var="dictionary">
                                                    <%--<option value="${dictionary.id}">${dictionary.name}</option>--%>
                                                    <c:if test="${dictionary.sid == hospitalized.sid}">
                                                        ${dictionary.name}
                                                    </c:if>
                                                </c:forEach>
                                            </h4>
                                            <h4>床位号：${hospitalized.bedId}号</h4>
                                            <h4>入住病因：${hospitalized.pathogeny}</h4>
                                            <%--<h4>入住时间：${stampToDate(hospitalized.checkTime)}</h4>--%>
                                            <h4>状态：
                                                <c:choose>
                                                    <c:when test="${hospitalized.status == 1}">
                                                        住院中
                                                    </c:when>
                                                    <c:when test="${hospitalized.status == 2}">
                                                        已出院
                                                    </c:when>
                                                </c:choose>
                                            </h4>
                                            <h4>入住时间：${hospitalized.checkTime}</h4>
                                            <h4>离开时间：${hospitalized.tuisuTime}</h4>
                                            <h4>已消费：${hospitalized.costValue}元</h4>
                                            <%--<h4>余额：${hospitalized.balance}元</h4>--%>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="tab-pane fade in" id="cysx" >

                            <div class="row">
                                <div class="col-lg-10"><br>
                                    <!-- 信息展示 -->
                                    <div class="box border pink">
                                        <div class="box-body big">
                                            <h4>已消费：${hospitalized.costValue}元</h4>
                                            <%--<h4>余额：${hospitalized.balance}元</h4>--%>
                                            <h4>
                                                <form:form class="form-horizontal"  method="post" action="${__ROOT__}/inpatient/tuisu" commandName="registration" role="form">
                                                    <input name="hid" type="hidden" value="${hospitalized.hid}">
                                                    确认出院： <button type="submit" class="btn btn-default input-sm">提交</button>
                                                </form:form>
                                            </h4>
                                        </div>
                                    </div>
                                 </div>
                            </div>

                        </div>

                        <%-- 取消代缴费用
                        <div class="tab-pane fade in" id="yjfy" >

                            <div class="row">
                                <div class="col-lg-10"><br>
                                    <!-- 信息展示 -->
                                    <div class="box border pink">
                                        <div class="box-body big">
                                            <h4>已消费：${hospitalized.costValue}元</h4>
                                            &lt;%&ndash;<h4>余额：${hospitalized.balance}元</h4>&ndash;%&gt;
                                            <h4>
                                                <form:form class="form-horizontal"  method="post" action="${__ROOT__}/inpatient/tuisu" commandName="registration" role="form">
                                                    <input name="hid" type="hidden" value="${hospitalized.hid}">
                                                    <input name="" >
                                                    确认出院： <button type="submit" class="btn btn-default input-sm">提交</button>
                                                </form:form>
                                            </h4>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
--%>
                    </div>

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

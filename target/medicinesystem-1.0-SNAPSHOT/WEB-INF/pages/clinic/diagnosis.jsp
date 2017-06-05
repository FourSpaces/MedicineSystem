<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 17-2-27
  Time: 下午9:45
  To change this template use File | Settings | File Templates.
  诊断页
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
            width: 360px;
            height: 100px;
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
                    <form:form class="form-horizontal"  method="get" action="${__ROOT__}/clinic/diagnosis" commandName="diagnosis" role="form">
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
                                挂号信息
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
                                    <c:when test="${userInfos.sex == 2}">
                                        女
                                    </c:when>
                                </c:choose>
                            </p>
                            <p class="list-group-item-text">
                                挂号科室：${dictionary.name}
                            </p>
                            <p class="list-group-item-text">
                                预约医生：${staffinfo.name}
                            </p>
                        </span>

                    </div>
                </div>
            </div>
        </div>


        <!-- 如果用户信息不为空 -->
        <c:if test="${!empty reservation}">
        <!-- 诊断 -->
        <div class="col-lg-8">
            <div id="" class="">
                <legend class=""><h4>诊断</h4></legend>
            </div>
            <form:form class="form-horizontal"  method="post" action="${__ROOT__}/clinic/diagnosis" commandName="diagnosis" role="form">
                <fieldset>
                    <div class="form-group">
                        <!-- Text input-->
                        <label class="col-sm-2 control-label" for="describes">病情描述</label>
                        <div class="col-sm-10 controls">
                            <input placeholder="请输入病情描述" class="input-sm" id="describes" name="describes" type="text" value="">
                        </div>
                    </div>

                    <div class="form-group">
                        <!-- Select Basic -->
                        <label class="col-sm-2 control-label" for="resolvents">治疗方案</label>
                        <div class="col-sm-10 controls">
                            <select class="input-sm" id="resolvents" name="resolvent">
                                <option value="0">--请选择--</option>
                                <option value="1">开药</option>
                                <option value="2">住院</option>
                            </select>
                            <br>
                        </div>
                    </div>

                    <div class="from-group">
                        <div class="col-sm-11">
                            <!-- BOX -->
                            <div class="box border blue">
                                <div class="box-body">
                                    <div class="row">
                                        <label class="col-md-2" for="drugsName">选择药品</label>
                                        <div class="col-md-5">
                                            <select id="drugsName" class="col-md-12 select2">
                                                <c:forEach items="${medicineList}" var="medic">
                                                    <option  value='"id":"${medic.mid}","name":"${medic.name}","price":"${medic.price}"'>${medic.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-md-3" >
                                            <label for="total">数量</label>
                                            <input id="total" type="number" class="input-sm" style="width: 48px;" value="1" >
                                        </div>
                                        <div class="col-md-1">
                                            <a id="addDrugs" class="btn btn-xs btn-info">添加</a>
                                        </div>
                                        <div class="col-md-10" id="drugsList"  style="font-size: 12px;">
                                            <table  class="table table-striped ">
                                                <thead>
                                                <tr>
                                                    <th>药品名称</th>
                                                    <th>数量</th>
                                                    <th>价格</th>
                                                    <th>操作</th>
                                                </tr>
                                                </thead>
                                                <tbody >
                                                </tbody>
                                            </table>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /BOX -->

                        </div>
                    </div>

                    <div class="form-group" style="display: none;" >
                        <!-- Text input-->
                        <label class="col-sm-2 control-label" for="contents">内容</label>
                        <div class="col-sm-10 controls">
                            <div class="textarea">
                                <textarea type="" class="" id="contents" name="content"></textarea>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <!-- Textarea -->
                        <label class="col-sm-2 control-label" for="remark">备注</label>
                        <div class="col-sm-10 controls">
                            <div class="textarea">
                                <textarea type="" class="" id="remark" name="remark"></textarea>
                            </div>
                        </div>
                    </div>

                    <!-- 把 id 一并写入  -->
                    <input type="hidden" name="rid" value="${reservation.rid}"/>
                    <input type="hidden" name="sid" value="${reservation.reservationDoctor}"/>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default input-sm">提交</button>
                        </div>
                    </div>
                </fieldset>
            </form:form>


        </div>
        </c:if>
    </div>
</views:override>

<views:override name="page_script">
    <script  type="text/javascript" src="${__RES__}/js/jquery.table-json.conversion.js" ></script>
    <script>
        $(document).ready(function() {
            $(".select2").select2();
        });

        var commas = "";
        //添加按钮的事件,获取数据
        $("#addDrugs").on("click", function(){
            //获取药品名字 和 用药数量
            var drugs = $("#drugsName").val();
            var total = $("#total").val();
            //组装成为JSON 语句
            drugs+=',"total":"'+total+'"';

            $("#contents").append(commas+"{"+drugs+"}");
            //配置分隔符
            commas = ",";
            console.log($("#contents").html());
            //生成JSON
            var jsonlist1 = JSON.parse("["+$("#contents").html()+"]");
            var jsonTable = [];

            for(var i in jsonlist1){
                var del = "<a class='deltr' data-id='"+i+"' >删除</a>";
                var jt = {"#":i ,"药品名称":jsonlist1[i].name, "数量":jsonlist1[i].total, "价格":(jsonlist1[i].price*jsonlist1[i].total)+"", "操作":del};
                jsonTable.push(jt);
            }

            //列表
            $("#drugsList").html('');

            //生成表格
            $.jsonToTable(jsonTable, { id: "#drugsList",header: true, className: "table table-striped"});

        })

        //添加删除按钮的事件
        $("#drugsList").on("click",".deltr", function(){
            //获得当前数据
            var id = $(this).attr("data-id");
            jsonTable = [];
            var jsonlist1 = JSON.parse("["+$("#contents").html()+"]");
            //delete jsonlist1[id];
            jsonlist1.splice(id, 1);
            for(var i in jsonlist1){
                var del = "<a class='deltr' data-id='"+i+"' >删除</a>";
                var jt = {"#":i ,"药品名称":jsonlist1[i].name, "数量":jsonlist1[i].total, "价格":(jsonlist1[i].price*jsonlist1[i].total)+"", "操作":del};
                jsonTable.push(jt);
            }

            var jsonString = JSON.stringify(jsonlist1);

            jsonString = jsonString.substring(1,jsonString.length-1)+"";

            if(jsonString=="")
                commas = "";

            $("#contents").html(jsonString);
            //列表
            $("#drugsList").html('');

            //生成表格
            $.jsonToTable(jsonTable, { id: "#drugsList",header: true, className: "table table-striped"});
        });

    </script>
</views:override>

<%@include file="/WEB-INF/pages/public/base.jsp"%>

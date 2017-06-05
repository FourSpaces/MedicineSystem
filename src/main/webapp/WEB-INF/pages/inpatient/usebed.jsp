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
        <!-- 如果住院信息不存在 -->
        <div  class="col-lg-8" >
            <div>
                <legend ><h4>病床详情</h4></legend>
            </div>
            <div class="row" >
                <ul id="myTab" class="nav nav-tabs">

                    <li class="active"><a href="#home" data-toggle="tab">住院病床列表</a></li>
                    <li class=""><a href="#kongchuang" data-toggle="tab">空床列表</a></li>
                </ul>
                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane fade in active" id="home">
                        <h4>已用床：${useBedValue}张</h4>
                        <!-- 如果字典列表非空 -->
                        <c:if test="${!empty useBedList}">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>床位号</th>
                                    <th>患者名</th>

                                    <th>病情描述</th>
                                    <th>性别</th>

                                    <th>入住时间</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${useBedList}" var="medic">
                                    <tr>
                                        <td>${medic.id}</td>
                                        <td>${medic.name}</td>

                                        <td>${medic.pathogeny}</td>
                                        <td><c:choose>
                                            <c:when test="${medic.sex == 1}">
                                                男
                                            </c:when>
                                            <c:when test="${medic.sex == 2}">
                                                女
                                            </c:when>
                                        </c:choose></td>

                                        <td>${medic.updateTime}</td>

                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>

                        </c:if>

                    </div>

                    <div class="tab-pane fade in " id="kongchuang">
                        <h4>还有空床：${useNoBedValue}张</h4>
                        <!-- 如果字典列表非空 -->
                        <c:if test="${!empty useNoBedList}">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>床位号</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${useNoBedList}" var="medic">
                                    <tr>
                                        <td>${medic.id}</td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>

                        </c:if>

                    </div>
                </div>
            </div>
        </div>

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

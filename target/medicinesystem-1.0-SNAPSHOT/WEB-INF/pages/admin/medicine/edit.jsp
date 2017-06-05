<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 17-3-5
  Time: 上午9:30
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
    <!-- 显示数据字典的表格 statr -->
    <div class="row">

        <!-- 编辑工作人员 -->
        <div class="col-lg-6">
            <!-- 添加基本数据 -->
            <div id="" class="">
                <legend class=""><h4>编辑药品信息</h4></legend>
            </div>

            <form:form action="${__ROOT__}/admin/medicine/${editPage}" class="form-horizontal"  method="post"  commandName="medicine" role="form">

                <input type="hidden" name="mid" value="${medicine.mid}"/>
                <fieldset>
                    <div class="form-group">
                        <!-- Text input-->
                        <label class="col-sm-3 control-label" for="usernames">药品名字</label>
                        <div class="col-sm-9 controls">
                            <input placeholder="请输入药品名称" class="input-sm" id="usernames" name="name" type="text" value="${medicine.name}" >
                        </div>
                    </div>

                    <div class="form-group">
                        <!-- Text input-->
                        <label class="col-sm-3 control-label" for="units">单位</label>
                        <div class="col-sm-9 controls">
                            <input placeholder="单位" id="units"  name="unit" class="input-sm" type="text" value="${medicine.unit}" >
                        </div>
                    </div>

                    <div class="form-group">
                        <!-- Text input-->
                        <label class="col-sm-3 control-label" for="prices">价格</label>
                        <div class="col-sm-9 controls">
                            <input placeholder="请输入价格" id="prices" name="price" class="input-sm" type="text" value="${medicine.price}" >
                            <p class="help-block"></p>
                        </div>
                    </div>

                    <div class="form-group">
                        <!-- Textarea -->
                        <label class="col-sm-3 control-label" for="userremarks">备注</label>
                        <div class="col-sm-9 controls">
                            <div class="textarea">
                                <textarea type="" class="" id="userremarks" name="remark">${medicine.remark}</textarea>
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
    </div>
    <!-- 显示数据字典的表格 end -->

</views:override>

<views:override name="page_script">
    <script>
        $(document).ready(function() {
            $(".select2").select2();
        });
    </script>
</views:override>

<%@include file="/WEB-INF/pages/public/base.jsp"%>

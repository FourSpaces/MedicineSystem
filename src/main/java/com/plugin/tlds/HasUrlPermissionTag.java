package com.plugin.tlds;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * @ClassName: HasUrlPermissionTag
 * @Description: 根据url判断权限标签
 * @author: liuyx
 * @date: 2015年12月21日上午11:15:32
 */
public class HasUrlPermissionTag extends BodyTagSupport {

    private String link;//  acApplication/forMain.do

    @Override
    public int doStartTag() throws JspException { // 在标签开始处出发该方法

        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        //获取session中存放的权限

        //判断是否有权限访问
        if (0 == 0) {
            //允许访问标签body
            return BodyTagSupport.EVAL_BODY_INCLUDE;// 返回此则执行标签body中内容，SKIP_BODY则不执行
        } else {
            return BodyTagSupport.SKIP_BODY;
        }

    }

    @Override
    public int doEndTag() throws JspException {
        return BodyTagSupport.EVAL_BODY_INCLUDE;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}

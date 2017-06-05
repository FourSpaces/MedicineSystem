package com.plugin.tlds;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Kevin on 2017/4/4.
 */
public class DateTag extends BodyTagSupport {

    private static final long serialVersionUID = 6464168398214506236L;

    private String value;

    @Override
    public int doStartTag() throws JspException {
        String vv = "" + value;
        try {
            long time = Long.valueOf(vv.trim())*1000;
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(time);
            //SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            String s = dateformat.format(c.getTime());
            pageContext.getOut().write(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }

    public void setValue(String value) {
        this.value = value;
    }

}
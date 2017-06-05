package com.controller;

import com.model.StaffInformationEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by kevin on 17-2-13.medicinesystem
 */
public class configure {

    public final String rootPath ="/medicinesystem";
    //部门字典
    public final int departmentCode = 1;
    //当前时间戳
    public final Integer nowTime = new Integer(Long.toString(System.currentTimeMillis()/1000));

    public Integer nowDate;

    public configure(){
        try
        {
            //获得当前日期戳
            Date date = new Date();
            String dateString = new SimpleDateFormat("yyyy-MM-dd ").format(date);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
            Date date1 = sdf.parse(dateString);
            this.nowDate = new Integer(Long.toString(date1.getTime()/1000));

        }catch (ParseException e)
        {
            System.out.println(e.getMessage());
        }
    }

    //工作类型 <1:门诊部医师 , 2:门诊部护士 , 3:"工作人员" , 4:"住院部医师" , 5:"住院部护士">
    public Map<Integer,String> jobTypeMap = new HashMap<Integer,String>(){
        {
            put(1,"门诊部医师");
            put(2,"门诊部护士");
            put(3,"工作人员");
            put(4,"住院部医师");
            put(5,"住院部护士");
            put(6,"系统管理员");
        }
    };

    //编制状态 <1:有编制, 2：临时工>
    public Map<Byte,String> organizationMap = new HashMap<Byte,String>(){
        {
            put(Byte.valueOf("1"),"有编制");
            put(Byte.valueOf("2"),"无编制");
        }
    };

    //性别  <1:男 2：女>',
    public Map<Byte,String> sexMap = new HashMap<Byte, String>(){
        {
            put(Byte.valueOf("1"),"男");
            put(Byte.valueOf("2"),"女");
        }
    };

    //配置模块
    public Map<String, String> configMap = new HashMap<String, String>(){
        {
            //put("__ROOT__", "/medicinesystem");
            put("__ROOT__", "");
            put("__RES__", this.get("__ROOT__")+"/res");
            put("NOW_TIME", Long.toString(System.currentTimeMillis()/1000));

        }
    };

    public Map<String,Map> configPairsMap = new HashMap<String,Map>(){
        {
            put("jobTypeMap",jobTypeMap);
            put("organizationMap",organizationMap);
            put("sexMap",sexMap);

        }
    };

    /**
     * 初始化配置  到  model 中
     * @param model
     */
    public void initModelMap(ModelMap model){
        //遍历 configMap ,添加到ModelMap 中
        Iterator iter = this.configMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            model.addAttribute(entry.getKey().toString(),entry.getValue().toString());
        }

        //遍历 configPairsMap ,添加到 ModelMap 中
        //Integer iter1 = this.configPairsMap.entrySet().iterator();
        Set<String> get = this.configPairsMap.keySet();
        for (String key:get) {
            model.addAttribute(key,this.configPairsMap.get(key));
        }

    }

    /**利用MD5进行加密
     * @param str  待加密的字符串
     * @return  加密后的字符串
     * @throws NoSuchAlgorithmException  没有这种产生消息摘要的算法
     * @throws UnsupportedEncodingException
     */
    public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }

    @ModelAttribute
    public void init(ModelMap model, HttpSession httpSession){
        StaffInformationEntity userInfo = (StaffInformationEntity)httpSession.getAttribute("userinfo");
        model.addAttribute("userInfo",userInfo);
    }
}

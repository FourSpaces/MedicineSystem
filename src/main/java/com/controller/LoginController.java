package com.controller;

import com.model.StaffInformationEntity;
import com.repository.StaffInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by Kevin on 2017/4/3.
 */

/* 公共模块处理*/
@Controller
public class LoginController extends configure  {

    // 自动装配数据库接口，不需要再写原始的Connection来操作数据库
    @Autowired
    StaffInformationRepository staffInformationRepository;


    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String index(){
        return "redirect:/public/index";
    }

    /**
     *  用户登录
     * @param model
     * @return
     */

    @RequestMapping(value ="/login", method = RequestMethod.GET)
    public String login( ModelMap model){

        //载入根路径配置信息等
        this.initModelMap(model);
        return "admin/login/login";
    }

    @RequestMapping(value ="/login", method = RequestMethod.POST)
    public String loginPost(@ModelAttribute("user") StaffInformationEntity staffInformation, ModelMap model, HttpSession httpSession)throws NoSuchAlgorithmException, UnsupportedEncodingException {


        //查询对应工号的信息
        List<StaffInformationEntity> staffInfoList = staffInformationRepository.findByJobNumber(staffInformation.getJobNumber().toUpperCase());

        if(staffInfoList.size() >= 1){
            StaffInformationEntity staff = staffInfoList.get(0);
            //进行大小转换
            //staffInformation.setPassword(staffInformation.getPassword().toUpperCase()); ;
            //对密码做一个MD5加密，进行验证
            if(this.EncoderByMd5(staffInformation.getPassword()).equals(staff.getPassword())){
                //获取用户信息，用户类型暂存到session中，进行权限方面的设置
                httpSession.setAttribute("userinfo", staff);
                return "redirect:/public/index";
            }else{
                //提示用户信息错误
                return"redirect:/login?tab=1";
            }
        }
        else{
            //用户名不存在，需要重新输入
            return"redirect:/login?tab=1";
        }

    }

    //注销用户
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model, HttpSession httpSession){
        //删除session
        httpSession.invalidate();
        return"redirect:/login";
    }
}

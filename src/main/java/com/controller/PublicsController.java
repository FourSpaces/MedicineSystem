package com.controller;

/**
 * Created by kevin on 17-2-13.
 */

import com.model.CostEntity;
import com.model.DictionaryEntity;
import com.model.StaffInformationEntity;
import com.model.UserInfoEntity;
import com.repository.CostRepository;
import com.repository.DictionaryRepository;
import com.repository.StaffInformationRepository;
import com.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/* 公共模块处理*/
@Controller
@RequestMapping("/public")
public class PublicsController extends configure {

    // 自动装配数据库接口，不需要再写原始的Connection来操作数据库
    @Autowired
    StaffInformationRepository staffInformationRepository;
    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    DictionaryRepository dictionaryRepository;
    @Autowired
    CostRepository costRepository;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String showIndex(ModelMap model){
        model.addAttribute("sidebarValue", "/public/index");
        //载入根路径
        this.initModelMap(model);
        return "clinic/index";
    }


    /**
     *  添加用户
     * @param userInfoEntity
     * @param model
     * @return
     */
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String adduser(@ModelAttribute("userinfo") UserInfoEntity userInfoEntity , ModelMap model){

        //配置创建时间默认值
        userInfoEntity.setRegTime(new Integer(Long.toString(System.currentTimeMillis()/1000)));
        //配置状态默认值
        userInfoEntity.setStatus(Byte.parseByte("1"));
        // 注意此处，post请求传递过来的是一个UserEntity对象，里面包含了该用户的信息
        // 通过@ModelAttribute()注解可以获取传递过来的'user'，并创建这个对象

        // 数据库中添加一个用户，并立即刷新缓存
        userInfoRepository.saveAndFlush(userInfoEntity);

        //载入根路径配置
        this.initModelMap(model);
        return "redirect:/clinic/registration?phone="+userInfoEntity.getPhone();
    }


    /**
     *  字典信息列表页
     * @param model
     * @return
     */
    @RequestMapping(value = "/dictionary",method = RequestMethod.GET)
    public String showDictionaryList(ModelMap model){
        // 查询user表中所有记录
        List<DictionaryEntity> dictionaryList = dictionaryRepository.findAll();

        // 将所有记录传递给要返回的jsp页面，放在userList当中
        // model：用于将controller方法里面的参数传递给所需的jsp页面，以进行相关显示。
        model.addAttribute("dictionaryList", dictionaryList);
        model.addAttribute("sidebarValue", "/public/dictionary");
        //载入根路径配置
        this.initModelMap(model);
        return "dictionary/list";
    }

    /**
     *  添加字典信息页
     * @param model
     * @return
     */
    @RequestMapping(value = "/dictionary/add",method = RequestMethod.GET)
    public String addDictionaryListGet(ModelMap model){
        //查询字典数据
        //获取顶级字段
        List<DictionaryEntity> dictionaryList = dictionaryRepository.findByParent(0);

        model.addAttribute("dictionaryList", dictionaryList);
        model.addAttribute("sidebarValue", "/public/dictionary");
        this.initModelMap(model);
        return "dictionary/edit";
    }

    /**
     *  添加提交字典信息
     * @param dictionaryEntity
     * @param model
     * @return
     */
    @RequestMapping(value = "/dictionary/add",method = RequestMethod.POST)
    public String  addDictionaryListPost(@ModelAttribute("dictionary") DictionaryEntity dictionaryEntity, ModelMap model){

        //查询字典数据
        //获取字典数据【科室】
        // 数据库中添加一个用户，并立即刷新缓存
        dictionaryRepository.saveAndFlush(dictionaryEntity);
        //载入根路径
        this.initModelMap(model);

        return "redirect:/public/dictionary";
    }


    /**
     *  字典更新get
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping(value = "/dictionary/update/{id}",method = RequestMethod.GET)
    public String updateDictionaryGet(@PathVariable("id") Integer userId,ModelMap model){

        // 找到userId所表示的用户
        DictionaryEntity dictionaryEntity = dictionaryRepository.findOne(userId);

        // 传递给请求页面
        model.addAttribute("dictionary", dictionaryEntity);
        model.addAttribute("sidebarValue", "/public/dictionary");
        //载入根路径
        this.initModelMap(model);
        return "dictionary/update";
    }


    /**
     *  字典更新post
     * @param dictionaryEntity
     * @return
     */
    @RequestMapping(value = "/dictionary/update", method = RequestMethod.POST)
    public String updateUserPost(@ModelAttribute("update") DictionaryEntity dictionaryEntity) {

        //配置更新值
        dictionaryEntity.setUpdateTime(new Integer(Long.toString(System.currentTimeMillis()/1000)));

        // 更新用户信息
        dictionaryRepository.updateDictionary(dictionaryEntity.getParent(),dictionaryEntity.getName(),dictionaryEntity.getValue(),dictionaryEntity.getDetails(),
                dictionaryEntity.getRemark(),dictionaryEntity.getStatus(),dictionaryEntity.getSort(),dictionaryEntity.getUpdateTime(),dictionaryEntity.getId());
        dictionaryRepository.flush(); // 刷新缓冲区
        return "redirect:/public/dictionary";
    }

    /**
     *  删除表单信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/dictionary/delete/{id}", method = RequestMethod.GET)
    public String deleteDictionaryGet(@PathVariable("id") Integer id,ModelMap model){

        //10以下的保留信息，不能删除
        if(id >= 10){
            // 删除id对应的字段记录
            dictionaryRepository.delete(id);
            // 立即刷新
            dictionaryRepository.flush();
        }
        else{
            //这里对错误信息 配置一个 cookie;
        }

        return "redirect:/public/dictionary";
    }


    //对人员信息进行管理【待写】


    //对缴费信息进行管理

    /**
     *  缴费成功
     * @param cid
     * @param model
     * @return
     */
    @RequestMapping(value = "/cost/pay/{cid}",method = RequestMethod.POST)
    public String updateDictionaryGet(@PathVariable("cid") int cid,ModelMap model){

        //更新付款状态
        costRepository.updateReceivable(Byte.parseByte("1"),new Integer(Long.toString(System.currentTimeMillis()/1000)),cid);

        //载入根路径配置信息等
        this.initModelMap(model);

        model.addAttribute("timeTab","timeTab");
        model.addAttribute("toUrl","/clinic/index");
        model.addAttribute("timeValue",3);
        return "pay/result";
    }


    //药品管理
    @RequestMapping(value = "/chemist",method = RequestMethod.GET)
    public String getChemistGet(@RequestParam(value = "rid",required = false) Integer rid, ModelMap model){
        //根据用户id  获取 用户的的缴费信息 和 用户的取药列表
        if(rid != null){
            List<CostEntity> costList = costRepository.findByRidAndCostTypeOrderByCreateTime(rid,3);
            CostEntity cost = costList.get(0);
            model.addAttribute("cost",cost);
            model.addAttribute("rid",rid);

        }

        //载入根路径配置信息等
        this.initModelMap(model);
        return "chemist/index";
    }



    //
    @RequestMapping(value ="/aboutPassword", method = RequestMethod.GET)
    public String aboutPassword( ModelMap model, HttpSession httpSession ){

        StaffInformationEntity userInfo = (StaffInformationEntity)httpSession.getAttribute("userinfo");
        // 查询user表中所有记录
        List<StaffInformationEntity> staffInformationList = new ArrayList<StaffInformationEntity>();

        if(userInfo.getJobType() == 6){
            staffInformationList = staffInformationRepository.findAll();
        }else{
            staffInformationList.add(userInfo);
        }

        // model：用于将controller方法里面的参数传递给所需的jsp页面，以进行相关显示。
        model.addAttribute("staffInformationList", staffInformationList);

        //载入根路径配置信息等
        model.addAttribute("sidebarValue", "/public/aboutPassword");
        this.initModelMap(model);
        return "admin/password/list";
    }

    //编辑数据
    @RequestMapping(value = "/aboutPassword/edit/{sid}", method = RequestMethod.GET)
    public String staffEditGet(@ModelAttribute("sid") int sid, ModelMap model) {

        //获得对应的数据
        StaffInformationEntity staffInformationEntity = staffInformationRepository.findOne(sid);

        // 传递给请求页面
        model.addAttribute("staffInformation", staffInformationEntity);
        model.addAttribute("editPage", "edit");
        model.addAttribute("sidebarValue", "/public/aboutPassword");
        //载入根路径配置信息等
        this.initModelMap(model);
        return "admin/password/edit";
    }

    @RequestMapping(value = "/aboutPassword/edit", method = RequestMethod.POST)
    public String staffEditPost(@ModelAttribute("staff") StaffInformationEntity staffInformation, ModelMap model) {

        String password = "";
        try {
            password = this.EncoderByMd5(staffInformation.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //保持数据
        staffInformationRepository.updatePassword(password,staffInformation.getSid());
        // 完成后 进行返员工列表页
        return "redirect:/public/aboutPassword";
    }


}

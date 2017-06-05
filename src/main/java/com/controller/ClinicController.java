package com.controller;

/**
 * Created by kevin on 17-2-13.
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.model.*;
import com.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/* 门诊业务模块处理*/
@Controller
@RequestMapping("/clinic")
public class ClinicController extends configure {

    // 自动装配数据库接口，不需要再写原始的Connection来操作数据库
    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    DictionaryRepository dictionaryRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    CostRepository costRepository;
    @Autowired
    StaffInformationRepository staffInformationRepository;
    @Autowired
    DiagnosisRepository diagnosisRepository;
    @Autowired
    PrescriptionRepository prescriptionRepository;
    @Autowired
    MedicineRepository medicineRepository;

    /**
     *  门诊部首页
     * @param model
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String showIndex(ModelMap model){
        //载入根路径
        this.initModelMap(model);
        model.addAttribute("message","欢迎来登录门诊部");
        return "clinic/index";
    }

    /**
     *  门诊部挂号get
     * @param phone
     * @param model
     * @return
     */
    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public String registrationGet(@ModelAttribute("phone") String phone, ModelMap model){
        if(phone == null){
            phone = "";
        }
        UserInfoEntity userInfoEntity = userInfoRepository.findByPhone(phone);
        if(userInfoEntity == null){
            model.addAttribute("phone", phone);
        }
        //获取顶级字段
        List<DictionaryEntity> dictionaryList = dictionaryRepository.findByParent(this.departmentCode);
        model.addAttribute("dictionaryList", dictionaryList);

        //获取手机号参数
        model.addAttribute("userInfos",userInfoEntity);
        model.addAttribute("sidebarValue", "/clinic/registration");
        //载入根路径配置信息等
        this.initModelMap(model);
        return "clinic/registration";
    }


    /**
     * 挂号提交页面
     * @param reservationEntity
     * @param model
     * @param costEntity
     * @return
     */
    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public String registrationPost(@ModelAttribute("registration") ReservationEntity reservationEntity , ModelMap model , CostEntity costEntity){

        //配置挂号时间
        reservationEntity.setCreateTime(new Integer(Long.toString(System.currentTimeMillis()/1000)));
        //保存挂号信息
        reservationEntity = reservationRepository.saveAndFlush(reservationEntity);

        //这里虽然创建了 costEntity 对象，但却是一个空对象，需要构造参数
        costEntity.setRid(reservationEntity.getRid());
        costEntity.setCostType(1);  //设置类型为 挂号
        costEntity.setReceivableProject(reservationEntity.getRid());    //配置id
        costEntity.setReceivable(reservationEntity.getReservationCost().doubleValue());     //配置付款
        costEntity.setIsReceivable(Byte.valueOf("0"));     //配置付款状态
        costEntity.setCreateTime(this.nowTime);
        costEntity.setStatus(Byte.valueOf("0"));

        //保存数据到费用表中
        costEntity = costRepository.saveAndFlush(costEntity);

        model.addAttribute("cost",costEntity);
        //载入根路径配置信息等
        this.initModelMap(model);

        return "pay/bill";
    }

    //诊断页面
    @RequestMapping(value = "/diagnosis",method = RequestMethod.GET)
    public String dignosisGet(@RequestParam(value = "rid",required = false) Integer rid, ModelMap model){

        if(rid == null){
            rid = 0;
        }
        //查询挂号信息
        ReservationEntity reservation = reservationRepository.findByRidAndCreateTimeGreaterThan(rid,this.nowDate);

        if(reservation != null){
            //获得挂号人信息
            UserInfoEntity userInfo = userInfoRepository.findOne(reservation.getUid());
            //查询科室信息
            DictionaryEntity  dictionary = dictionaryRepository.findOne(reservation.getReservationDepartment());
            //查询医生信息
            StaffInformationEntity staffinfo = staffInformationRepository.findOne(reservation.getReservationDoctor());

            model.addAttribute("reservation",reservation);
            model.addAttribute("userInfos",userInfo);
            model.addAttribute("dictionary",dictionary);
            model.addAttribute("staffinfo",staffinfo);
        }

        //获得药品列表页面
        List<MedicineEntity> medicineList = medicineRepository.findAll();
        //载入根路径配置信息等
        model.addAttribute("medicineList",medicineList);

        model.addAttribute("rid",rid);
        model.addAttribute("title","诊断页面");
        model.addAttribute("sidebarValue", "/clinic/diagnosis");
        //载入根路径配置信息等
        this.initModelMap(model);
        return "clinic/diagnosis";
    }

    //诊断页面
    @RequestMapping(value = "/diagnosis",method = RequestMethod.POST)
    public String dignosisPost(@ModelAttribute("diagnosis") DiagnosisEntity diagnosisEntity, ModelMap model, PrescriptionEntity prescriptionEntity ){


        //diagnosisEntity.setStatus(Byte.valueOf("1"));
        //diagnosisEntity.setCreateTime(new Integer(this.nowTime));

        //获得诊断信息
        diagnosisEntity = diagnosisRepository.saveAndFlush(diagnosisEntity);

        if(diagnosisEntity.getResolvent() == 1){
            //开药
            prescriptionEntity.setRid(diagnosisEntity.getRid());
            prescriptionEntity.setSid(diagnosisEntity.getSid());
            prescriptionEntity.setContent(diagnosisEntity.getContent());
            prescriptionEntity.setCreateTime(this.nowTime);
            prescriptionEntity.setRemark(diagnosisEntity.getRemark());

            //生成处方单
            prescriptionRepository.saveAndFlush(prescriptionEntity);
            //生成费用
            //{"id":"56","name":"安药 抗病毒口服液","price":"12.0","total":"1"}
            String drugJson = "["+diagnosisEntity.getContent()+"]";

            Gson gson = new Gson();
            //解析json字符串
            List<DrugDetails> druglist = gson.fromJson(drugJson, new TypeToken<List<DrugDetails>>(){}.getType());

            double value = 0;
            for (DrugDetails drug:druglist) {
                value += drug.getPrice()*drug.getTotal();
            }

            //生成 费用对象
            CostEntity cost = new CostEntity();
            cost.setRid(diagnosisEntity.getRid());
            cost.setCostType(3);
            cost.setReceivableProject(diagnosisEntity.getDid());
            cost.setReceivable(value);
            cost.setIsReceivable(Byte.valueOf("0"));
            cost.setCreateTime(this.nowTime);
            cost.setRemark(drugJson);
            cost.setStatus(Byte.valueOf("1"));

            cost = costRepository.saveAndFlush(cost);

            model.addAttribute("cost",cost);
            //载入根路径配置信息等
            this.initModelMap(model);

            return "pay/bill";
        }
        /*else if(diagnosisEntity.getResolvent() == 2){


        }*/
        else{
            this.initModelMap(model);
            model.addAttribute("timeTab","timeTab");
            model.addAttribute("toUrl","/clinic/diagnosis");
            model.addAttribute("timeValue",2);

            return "/clinic/result";
        }
        //判断诊断类型
        //生成诊断表
        //载入根路径配置信息等


    }




}

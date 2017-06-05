package com.controller;

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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 17-3-7.
 */
@Controller
@RequestMapping("/inpatient")
public class InpatientController extends configure {
    @Autowired
    HospitalizedRepository hospitalizedRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    DiagnosisRepository diagnosisRepository;
    @Autowired
    DictionaryRepository dictionaryRepository;
    @Autowired
    StaffInformationRepository staffInformationRepository;
    @Autowired
    BedRepository bedRepository;
    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    CostRepository costRepository;
    @Autowired
    MedicineRepository medicineRepository;
    @Autowired
    PrescriptionRepository prescriptionRepository;


    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String inpatientInfo(@RequestParam(value = "rid",required = false) Integer rid, @RequestParam(value = "hid",required = false) Integer hid, ModelMap model){

        if(rid == null) rid = 0;
        if(hid == null) hid = 0;

        if(rid != 0 || hid != 0 ){
            //定义变量
            HospitalizedEntity hospitalizedEntity = null;
            DiagnosisEntity diagnosisEntity = null;
            ReservationEntity reservationEntity = null;

            //已经住院的情况下
            if(rid != 0){
                hospitalizedEntity = hospitalizedRepository.findByRid(rid);
                model.addAttribute("rid",rid);
            }
            else{
                hospitalizedEntity = hospitalizedRepository.findByHid(hid);
                model.addAttribute("hid",hid);
            }

            //判断查询是否为空
            if(hospitalizedEntity == null && rid != 0){
                diagnosisEntity = diagnosisRepository.findByRid(rid);
                reservationEntity = reservationRepository.findOne(rid);
            }else{
                diagnosisEntity = diagnosisRepository.findByRid(hospitalizedEntity.getRid());
                reservationEntity = reservationRepository.findOne(hospitalizedEntity.getRid());
            }

            UserInfoEntity userInfoEntity = userInfoRepository.findOne(reservationEntity.getUid());
            model.addAttribute("hospitalized",hospitalizedEntity);
            model.addAttribute("diagnosis",diagnosisEntity);
            model.addAttribute("reservation",reservationEntity);
            model.addAttribute("userInfos",userInfoEntity);

            //获得部门信息
            List<DictionaryEntity> dictionaryList = dictionaryRepository.findByParent(this.departmentCode);
            model.addAttribute("dictionaryList", dictionaryList);
            //获得医师信息
            List<StaffInformationEntity> staffinfoList  = staffInformationRepository.findByDepartmentAndJobType(reservationEntity.getReservationDepartment(),4);
            model.addAttribute("staffinfoList", staffinfoList);

            //获得病床信息
            List<BedEntity> bedList = bedRepository.findByStatus(Byte.valueOf("0"));
            model.addAttribute("bedList", bedList);
        }


        model.addAttribute("sidebarValue", "/inpatient/index");
        //载入基础配置
        this.initModelMap(model);
        return "inpatient/index";
    }

    @RequestMapping(value ="/create",method = RequestMethod.POST)
    public String creataInpatient( ModelMap model, HttpServletRequest request){
        //获得基本数据
        Integer rid = Integer.valueOf( request.getParameter("rid"));
        Integer department = Integer.valueOf( request.getParameter("department"));
        Integer sid = Integer.valueOf( request.getParameter("sid"));
        Integer bedid = Integer.valueOf( request.getParameter("bedid"));
        String remark = request.getParameter("remark");
        double costValue = Double.parseDouble(request.getParameter("costValue"));

        //查询诊断单数据,判断诊断单
        DiagnosisEntity diagnosisEntity = diagnosisRepository.findByRid(rid);
        ReservationEntity reservationEntity = reservationRepository.findOne(rid);
        UserInfoEntity userInfoEntity = userInfoRepository.findOne(reservationEntity.getUid());

        //生成住院数据
        HospitalizedEntity hospitalizedEntity = new HospitalizedEntity();
        hospitalizedEntity.setRid(rid);
        hospitalizedEntity.setSid(sid);
        if(diagnosisEntity != null)
            hospitalizedEntity.setPathogeny(diagnosisEntity.getDescribes());
        hospitalizedEntity.setCheckTime(this.nowTime);
        hospitalizedEntity.setDepartment(department);
        hospitalizedEntity.setBedId(bedid);
        if (remark != null && remark != "")
            hospitalizedEntity.setRemark(remark);
        hospitalizedEntity.setStatus(Byte.valueOf("1"));
        //保存数据，获取住院id
        hospitalizedEntity = hospitalizedRepository.saveAndFlush(hospitalizedEntity);

        //更新病床数据
        bedRepository.updateDictionary(rid, sid, department, diagnosisEntity. getDescribes(), userInfoEntity.getName(), userInfoEntity.getSex(), this.nowTime, remark, Byte.valueOf("1"),bedid);

        //产生费用
        CostEntity costEntity = new CostEntity();
        costEntity.setRid(hospitalizedEntity.getHid()); //这里使用住院id 替代 挂号id
        costEntity.setCostType(4);//住院费用
        costEntity.setReceivableProject(hospitalizedEntity.getHid());
        costEntity.setReceivable(costValue);
        costEntity.setIsReceivable(Byte.valueOf("0"));
        costEntity.setCreateTime(this.nowTime);
        costEntity.setStatus(Byte.valueOf("1"));
        costEntity = costRepository.saveAndFlush(costEntity);


        //跳转到支付页面
        model.addAttribute("cost",costEntity);
        //载入根路径配置信息等
        this.initModelMap(model);
        return "pay/bill";
    }

    @RequestMapping(value = "/tuisu",method = RequestMethod.POST)
    public String inpatientTuisu( ModelMap model,@RequestParam(value = "hid",required = false) Integer hid ){

        //更新状态
        if(hid == null) hid = 0;
        hospitalizedRepository.updateStatus(hid,Byte.valueOf("2"), this.nowTime);

        //跳转链接
        //载入根路径配置信息等
        this.initModelMap(model);
        model.addAttribute("timeTab","timeTab");
        model.addAttribute("toUrl","/inpatient/index/?hid="+hid);
        model.addAttribute("timeValue",3);
        return "tiaozhuan/result";
    }

   // @RequestMapping(value = "/")
    @RequestMapping(value = "/bingchuanglist",method = RequestMethod.GET)
    public String bclist(ModelMap model ){

        //获得所有的已使用病床信息
        List<BedEntity> useBedList = bedRepository.findByStatus(Byte.valueOf("1"));
        //获得还未使用的病床信息
        List<BedEntity> useNoBedList = bedRepository.findByStatus(Byte.valueOf("0"));

        model.addAttribute("sidebarValue", "/inpatient/bingchuanglist");

        model.addAttribute("useBedList",useBedList);
        model.addAttribute("useBedValue",useBedList.size());
        model.addAttribute("useNoBedList",useNoBedList);
        model.addAttribute("useNoBedValue",useNoBedList.size());
        this.initModelMap(model);
        return "inpatient/usebed";
    }

    @RequestMapping(value = "/diagnosisList",method =  RequestMethod.GET)
    public String diagnosis(ModelMap model, HttpSession httpSession){
        StaffInformationEntity userInfo = (StaffInformationEntity)httpSession.getAttribute("userinfo");
        List<HospitalizedEntity> hospitalizedList = new ArrayList<HospitalizedEntity>();

        if(userInfo.getJobType() == 6){
            //获得所有的住院病人
            hospitalizedList =  hospitalizedRepository.findByStatus(Byte.valueOf("1"));
        }else{
            //获得当前医师所负责的病人
            hospitalizedList =  hospitalizedRepository.findBySidAndStatus(userInfo.getSid(),Byte.valueOf("1"));
        }
        this.initModelMap(model);
        model.addAttribute("hospitalizedList",hospitalizedList);
        model.addAttribute("sidebarValue", "/inpatient/diagnosisList");
        return "inpatient/diagnosis/list";
    }

    //诊断页面
    @RequestMapping(value = "/diagnosis/{hid}",method = RequestMethod.GET)
    public String dignosisGet(@ModelAttribute("hid") Integer hid, ModelMap model,HttpSession httpSession ){
        //获得当前操作人员id
        StaffInformationEntity doctorInfo = (StaffInformationEntity)httpSession.getAttribute("userinfo");
        //查询住院信息
        HospitalizedEntity hospitalized = hospitalizedRepository.findOne(hid);
        //查询挂号信息
        ReservationEntity reservation = reservationRepository.findOne(hospitalized.getRid());

        if(hospitalized != null && reservation != null){
            //获得挂号人信息
            UserInfoEntity userInfo = userInfoRepository.findOne(reservation.getUid());
            //查询科室信息
            DictionaryEntity dictionary = dictionaryRepository.findOne(reservation.getReservationDepartment());
            //查询历史药单
            List<DiagnosisEntity> diagnosisList = diagnosisRepository.findByRidAndTypesOrderByCreateTime(hid,Byte.valueOf("2"));

            model.addAttribute("reservation",reservation);
            //model.addAttribute("userInfo",userInfo);
            //model.addAttribute("dictionary",dictionary); //科室信息
            model.addAttribute("hid",hid); //科室信息
            model.addAttribute("sid",doctorInfo.getSid()); //科室信息
            model.addAttribute("diagnosisList",diagnosisList);

        }
        //获得药品列表页面
        List<MedicineEntity> medicineList = medicineRepository.findAll();
        //载入根路径配置信息等
        model.addAttribute("medicineList",medicineList);


        model.addAttribute("title","住院部诊断");
        model.addAttribute("sidebarValue", "/inpatient/diagnosisList");
        //载入根路径配置信息等
        this.initModelMap(model);
        return "inpatient/diagnosis/diagnosis";
    }

    //诊断页面
    @RequestMapping(value = "/diagnosis",method = RequestMethod.POST)
    public String dignosisPost(@ModelAttribute("diagnosis") DiagnosisEntity diagnosisEntity, ModelMap model, PrescriptionEntity prescriptionEntity ){
        diagnosisEntity.setStatus(Byte.valueOf("1"));
        diagnosisEntity.setCreateTime(this.nowTime);
        diagnosisEntity.setTypes(Byte.valueOf("2"));

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
        //判断诊断类型
        //生成诊断表
        //载入根路径配置信息等

        this.initModelMap(model);

        model.addAttribute("timeTab","timeTab");
        model.addAttribute("toUrl","/inpatient/diagnosisList");
        model.addAttribute("timeValue",2);

        return "/clinic/result";
    }



}

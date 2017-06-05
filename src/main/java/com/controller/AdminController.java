package com.controller;

import com.model.BedEntity;
import com.model.DictionaryEntity;
import com.model.MedicineEntity;
import com.model.StaffInformationEntity;
import com.repository.BedRepository;
import com.repository.DictionaryRepository;
import com.repository.MedicineRepository;
import com.repository.StaffInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kevin on 17-2-17.
 */

/* 系统管理模块处理*/
@Controller
@RequestMapping("/admin")
public class AdminController extends configure {

    @Autowired
    StaffInformationRepository staffInformationRepository;
    @Autowired
    DictionaryRepository dictionaryRepository;
    @Autowired
    MedicineRepository medicineRepository;
    @Autowired
    BedRepository bedRepository;

    /**
     * 员工列表
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/staffs", method = RequestMethod.GET)
    public String staffList(ModelMap model) {

        //获取部门列表
        HashMap<Integer, String> dictionaryMap = new HashMap<Integer, String>();
        List<DictionaryEntity> dictionaryList = dictionaryRepository.findByParent(this.departmentCode);

        //这里需要做一个优化，把查询优化到父类中
        for (DictionaryEntity dictionary : dictionaryList) {
            dictionaryMap.put(dictionary.getId(), dictionary.getName());
        }

        model.addAttribute("dictionaryMap", dictionaryMap);
        model.addAttribute("sidebarValue", "/admin/staffs");

        // 查询user表中所有记录
        List<StaffInformationEntity> staffInformationList = staffInformationRepository.findAll();

        // model：用于将controller方法里面的参数传递给所需的jsp页面，以进行相关显示。
        model.addAttribute("staffInformationList", staffInformationList);

        //载入根路径配置
        this.initModelMap(model);
        return "admin/staff/list";
    }

    /**
     * 添加员工页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/staff/add", method = RequestMethod.GET)
    public String staffAddGet(ModelMap model, StaffInformationEntity staffInformation) {

        //获得部门列表
        List<DictionaryEntity> dictionaryList = dictionaryRepository.findByParent(this.departmentCode);
        model.addAttribute("dictionaryList", dictionaryList);
        model.addAttribute("staffInformation", staffInformation);
        model.addAttribute("editPage", "add");
        model.addAttribute("sidebarValue", "/admin/staffs");
        //载入根路径配置信息等
        this.initModelMap(model);
        //
        return "admin/staff/edit";
    }

    /**
     * 添加员工到数据库中
     *
     * @param staffInformation
     * @return
     */
    @RequestMapping(value = "/staff/add", method = RequestMethod.POST)
    public String staffAddPost(@ModelAttribute("staff") StaffInformationEntity staffInformation) {

        //对密码进行MD5加密
        try {
            staffInformation.setPassword(this.EncoderByMd5("123456"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //保持数据
        staffInformationRepository.saveAndFlush(staffInformation);

        // 完成后 进行返员工列表页
        return "redirect:/admin/staffs";
    }

    //编辑员工
    @RequestMapping(value = "/staff/edit/{sid}", method = RequestMethod.GET)
    public String staffEditGet(@ModelAttribute("sid") int sid, ModelMap model) {

        //获得部门列表
        List<DictionaryEntity> dictionaryList = dictionaryRepository.findByParent(this.departmentCode);
        model.addAttribute("dictionaryList", dictionaryList);

        //获得对应的数据
        StaffInformationEntity staffInformationEntity = staffInformationRepository.findOne(sid);

        // 传递给请求页面
        model.addAttribute("staffInformation", staffInformationEntity);
        model.addAttribute("editPage", "edit");
        model.addAttribute("sidebarValue", "/admin/staffs");
        //载入根路径配置信息等
        this.initModelMap(model);
        return "admin/staff/edit";
    }

    @RequestMapping(value = "/staff/edit", method = RequestMethod.POST)
    public String staffEditPost(@ModelAttribute("staff") StaffInformationEntity staffInformation, ModelMap model) {

        //保持数据
        staffInformationRepository.updateStaffInfo(staffInformation.getName(), staffInformation.getSex(), staffInformation.getPhone(), staffInformation.getIdCard(), staffInformation.getAddress(),
                staffInformation.getJobNumber(), staffInformation.getDepartment(), staffInformation.getJobType(), staffInformation.getTitle(), staffInformation.getOrganization(),
                staffInformation.getInductionTime(), staffInformation.getDepartureTime(), staffInformation.getRemark(), staffInformation.getSid());
        // 完成后 进行返员工列表页
        return "redirect:/admin/staffs";
    }

    /**
     * 删除员工
     *
     * @param sid
     * @param model
     * @return
     */
    @RequestMapping(value = "/staff/delete/{sid}", method = RequestMethod.GET)
    public String deleteDictionaryGet(@PathVariable("sid") Integer sid, ModelMap model) {

        // 删除id对应的字段记录
        staffInformationRepository.delete(sid);
        // 立即刷新
        staffInformationRepository.flush();

        // 完成后 进行返员工列表页
        return "redirect:/admin/staffs";
    }


    /**
     * 药品管理
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/medicine", method = RequestMethod.GET)
    public String medicineListGet(ModelMap model) {

        //获得药品列表
        // 查询user表中所有记录
        List<MedicineEntity> medicineList = medicineRepository.findAll();
        //载入根路径配置信息等
        model.addAttribute("medicineList", medicineList);
        model.addAttribute("sidebarValue", "/admin/medicine");
        this.initModelMap(model);
        return "admin/medicine/list";
    }

    @RequestMapping(value = "/medicine/add", method = RequestMethod.GET)
    public String medicineAddGet(ModelMap model, MedicineEntity medicine) {

        medicine.setUnit("盒");

        //获得部门列表
        model.addAttribute("medicine", medicine);
        model.addAttribute("editPage", "add");
        model.addAttribute("sidebarValue", "/admin/medicine");
        //载入根路径配置信息等
        this.initModelMap(model);

        //载入配置信息
        this.initModelMap(model);
        return "admin/medicine/edit";

    }

    @RequestMapping(value = "/medicine/add", method = RequestMethod.POST)
    public String medicineAddPost(@ModelAttribute("medicine") MedicineEntity medicine) {
        //保持数据
        medicineRepository.saveAndFlush(medicine);

        // 完成后 重定向到列表页
        return "redirect:/admin/medicine";
    }

    //编辑数据
    @RequestMapping(value = "/medicine/edit/{mid}", method = RequestMethod.GET)
    public String medicineEditGet(@ModelAttribute("mid") int mid, ModelMap model) {

        //获得对应的数据
        MedicineEntity medicineEntity = medicineRepository.findOne(mid);

        // 传递给请求页面
        model.addAttribute("medicine", medicineEntity);
        model.addAttribute("editPage", "edit");
        model.addAttribute("sidebarValue", "/admin/medicine");
        //载入根路径配置信息等
        this.initModelMap(model);
        return "admin/medicine/edit";
    }

    @RequestMapping(value = "/medicine/edit", method = RequestMethod.POST)
    public String medicineEditPost(@ModelAttribute("medicine") MedicineEntity medicineEntity, ModelMap model) {

        //保持数据
        medicineRepository.updateDateInfo(medicineEntity.getName(), medicineEntity.getUnit(), medicineEntity.getPrice(),
                medicineEntity.getRemark(), medicineEntity.getStatus(), medicineEntity.getMid());
        // 完成后 进行返员工列表页
        return "redirect:/admin/medicine";
    }

    @RequestMapping(value = "/medicine/delete/{mid}", method = RequestMethod.GET)
    public String deleteMedicineGet(@PathVariable("mid") Integer mid) {
        // 删除id对应的字段记录
        medicineRepository.delete(mid);
        // 立即刷新
        medicineRepository.flush();

        // 完成后 进行返员工列表页
        return "redirect:/admin/medicine";
    }


    /**
     * 病床管理
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/bedlist", method = RequestMethod.GET)
    public String bedListGet(ModelMap model) {


        // 查询user表中所有记录
        List<BedEntity> bedList = bedRepository.findAll();
        //载入根路径配置信息等
        model.addAttribute("bedList", bedList);
        model.addAttribute("sidebarValue", "/admin/bedlist");
        this.initModelMap(model);
        return "admin/bed/list";
    }

    @RequestMapping(value = "/bed/add", method = RequestMethod.GET)
    public String bedAddGet(ModelMap model) {

        //载入根路径配置信息等
        this.initModelMap(model);
        model.addAttribute("sidebarValue", "/admin/bedlist");
        //载入配置信息
        this.initModelMap(model);
        return "admin/bed/edit";

    }

    @RequestMapping(value = "/bed/add", method = RequestMethod.POST)
    public String bedAddPost(@ModelAttribute("medicine") BedEntity medicine) {
        //保持数据
        bedRepository.saveAndFlush(medicine);

        // 完成后 重定向到列表页
        return "redirect:/admin/bed";
    }

    @RequestMapping(value = "/bed/delete/{id}", method = RequestMethod.GET)
    public String deleteBedGet(@PathVariable("id") Integer id) {
        // 删除id对应的字段记录
        medicineRepository.delete(id);
        // 立即刷新
        medicineRepository.flush();

        // 完成后 进行返员工列表页
        return "redirect:/admin/bed";
    }
}

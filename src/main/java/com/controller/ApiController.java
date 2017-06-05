package com.controller;

import com.model.ReservationEntity;
import com.model.StaffInformationEntity;
import com.repository.CostRepository;
import com.repository.ReservationRepository;
import com.repository.StaffInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by kevin on 17-2-23.
 */

//设计提供数据的
@Controller
@RequestMapping("/api")
public class ApiController extends configure {

    @Autowired
    StaffInformationRepository staffInformationRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    CostRepository costRepository;

    @RequestMapping(value = "/staff/info/{jobtype}/{did}", method =  RequestMethod.GET , produces = "application/json")
    public @ResponseBody List<StaffInformationEntity> getStaffInfo(@ModelAttribute("did") Integer did, @ModelAttribute("jobtype") Integer jobtype, ModelMap model){

        List<StaffInformationEntity> StaffInfoList = staffInformationRepository.findByDepartmentAndJobType(did,jobtype);

        return StaffInfoList;

    }


    @RequestMapping(value = "/reservation/info/{rid}", method =  RequestMethod.GET , produces = "application/json")
    public @ResponseBody ReservationEntity getReservationInfo(@ModelAttribute("rid") Integer rid, ModelMap model){
        //List<StaffInformationEntity> StaffInfoList = staffInformationRepository.findByDepartmentAndJobType(did,jobtype);

        ReservationEntity reservation = new ReservationEntity();
        try
        {
            //获得当前日期戳
            Date date = new Date();
            String dateString = new SimpleDateFormat("yyyy-MM-dd ").format(date);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
            Date date1 = sdf.parse(dateString);
            Integer newDate = new Integer(Long.toString(date1.getTime()/1000));

            //查询结果
            reservation = reservationRepository.findByRidAndCreateTimeGreaterThan(rid,newDate);

        }catch (ParseException e)
        {
            System.out.println(e.getMessage());
        }

        return reservation;
    }

    @RequestMapping(value = "/chemist/take/{cid}", method =  RequestMethod.GET , produces = "application/json")
    public @ResponseBody String getChemistTake(@ModelAttribute("cid") Integer cid, ModelMap model){

        costRepository.updateStatus(Byte.valueOf("3"),cid);
        return "ok";
    }
}

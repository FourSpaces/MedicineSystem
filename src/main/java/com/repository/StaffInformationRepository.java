package com.repository;

import com.model.StaffInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kevin on 17-2-17.
 */
public interface StaffInformationRepository extends JpaRepository<StaffInformationEntity, Integer> {

    @Modifying      // 说明该方法是修改操作
    @Transactional  // 说明该方法是事务性操作
    @Query("update StaffInformationEntity si set si.name =:qName, si.sex=:qSex, " +
            " si.phone =:qPhone, si.idCard =:qIdCard, si.address =:qAddress, si.jobNumber =:qJobNumber, " +
            " si.department =:qDepartment, si.jobType =:qJobType, si.title =:qTitle, si.organization =:qOrganization,  "+
            " si.inductionTime =:qInductionTime, si.departureTime =:qDepartureTime, si.remark =:qRemark "+
            "where si.sid =:qSid")
    public void updateStaffInfo(@Param("qName") String name, @Param("qSex") Byte sex,

                                 @Param("qPhone") String phone, @Param("qIdCard") String idCard,
                                 @Param("qAddress") String address, @Param("qJobNumber") String jobNumber,

                                 @Param("qDepartment") Integer department, @Param("qJobType") Integer jobType,
                                 @Param("qTitle") String title, @Param("qOrganization") Byte organization,

                                 @Param("qInductionTime") Integer inductionTime, @Param("qDepartureTime") Integer departureTime,

                                 @Param("qRemark") String remark, @Param("qSid") int sid);

    @Modifying      // 说明该方法是修改操作
    @Transactional  // 说明该方法是事务性操作
    @Query("update StaffInformationEntity si set si.password =:qPassword  where si.sid =:qSid")
    public void updatePassword(@Param("qPassword") String password, @Param("qSid") int sid);

    //查询手机号对应用户
    public List<StaffInformationEntity> findByDepartmentAndJobType(Integer department, Integer jobType);

    public List<StaffInformationEntity> findByJobNumber(String jobNumber);

    public StaffInformationEntity findBySid(int sid);

}

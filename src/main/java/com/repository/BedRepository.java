package com.repository;

import com.model.BedEntity;
import com.model.CostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by Kevin on 2017/3/28.
 */
public interface BedRepository extends JpaRepository<BedEntity, Integer> {

    @Modifying      // 说明该方法是修改操作
    @Transactional  // 说明该方法是事务性操作
    // 定义查询
    // @Param注解用于提取参数
    @Query("update BedEntity be set be.rid=:qRid, be.sid=:qSid, be.department=:qDepartment, be.pathogeny=:qPathogeny, be.name=:qName, be.sex=:qSex, be.updateTime=:qUpdateTime, be.remark=:qRemark, be.status=:qStatus where be.id=:qId")
    public void updateDictionary(@Param("qRid") Integer rid, @Param("qSid") Integer sid,
                                 @Param("qDepartment") Integer department, @Param("qPathogeny") String pathogeny,
                                 @Param("qName") String name, @Param("qSex") Byte sex,
                                 @Param("qUpdateTime") Integer updateTime, @Param("qRemark") String remark,
                                 @Param("qStatus") Byte status, @Param("qId") int id);

    @Modifying      // 说明该方法是修改操作
    @Transactional  // 说明该方法是事务性操作
    @Query("update BedEntity be set be.status=:qStatus where be.id =:qId")
    public void updateStatus(@Param("qId") int id, @Param("qStatus") Byte status);

    public List<BedEntity> findByStatus(Byte status);
}

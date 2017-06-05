package com.repository;

import com.model.DictionaryEntity;
import com.model.HospitalizedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Kevin on 2017/3/28.
 */
public interface HospitalizedRepository extends JpaRepository<HospitalizedEntity, Integer> {
    public HospitalizedEntity findByRid(int id);
    public HospitalizedEntity findByHid(int id);
    public List<HospitalizedEntity> findByStatus(Byte status);
    public List<HospitalizedEntity> findBySidAndStatus( Integer sid, Byte status);



    @Modifying      // 说明该方法是修改操作
    @Transactional  // 说明该方法是事务性操作
    @Query("update HospitalizedEntity he set he.status=:qStatus, he.tuisuTime=:qTuisu where he.id =:qId")
    public void updateStatus(@Param("qId") int id,@Param("qStatus") Byte status, @Param("qTuisu") int tuisuTime);



}

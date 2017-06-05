package com.repository;

import com.model.CostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kevin on 17-2-16.
 */
public interface CostRepository  extends JpaRepository<CostEntity, Integer>  {

    // 定义查询
    // @Param注解用于提取参数
    @Modifying      // 说明该方法是修改操作
    @Transactional  // 说明该方法是事务性操作
    @Query("update CostEntity co set co.isReceivable =:qReceivable, co.updateTime=:qUpdateTime where co.cid=:qCid")
    public void updateReceivable(@Param("qReceivable") Byte receivable, @Param("qUpdateTime") Integer updateTime, @Param("qCid") int cid);

    @Modifying      // 说明该方法是修改操作
    @Transactional  // 说明该方法是事务性操作
    @Query("update CostEntity co set co.status =:qStatus where co.cid=:qCid")
    public int updateStatus(@Param("qStatus") Byte status,@Param("qCid") int cid);

    //查询 挂号id对应的付款
    public List<CostEntity> findByRidAndCostTypeOrderByCreateTime (Integer rid, Integer costType);


}

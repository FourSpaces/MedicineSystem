package com.repository;

import com.model.MedicineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kevin on 17-3-4.
 */
public interface MedicineRepository  extends JpaRepository<MedicineEntity, Integer> {
/*
    private int mid;
    private String name;
    private String unit;
    private Double price;
    private String remark;
    private Byte status;

    */
    @Modifying      // 说明该方法是修改操作
    @Transactional  // 说明该方法是事务性操作
    @Query("update MedicineEntity me set me.name =:qName, me.unit=:qUnit, " +
            " me.price =:qPrice, me.remark =:qRemark, me.status =:qStatus "+
            "where me.mid =:qMid")
    public void updateDateInfo(@Param("qName") String name, @Param("qUnit") String unit,
                               @Param("qPrice") Double price,@Param("qRemark") String remark,
                                @Param("qStatus") Byte status, @Param("qMid") int mid);

}

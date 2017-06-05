package com.repository;

import com.model.DictionaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kevin on 17-2-15.
 */

@Repository
public interface DictionaryRepository extends JpaRepository<DictionaryEntity, Integer> {


    @Modifying      // 说明该方法是修改操作
    @Transactional  // 说明该方法是事务性操作
    // 定义查询
    // @Param注解用于提取参数
    @Query("update DictionaryEntity di set di.parent=:qParent, di.name=:qName, di.value=:qValue, di.details=:qDetails, di.remark=:qRemark, di.status=:qStatus, di.sort=:qSort, di.updateTime=:qUpdateTime where di.id=:qId")
    public void updateDictionary(@Param("qParent") Integer parent, @Param("qName") String name,
                                 @Param("qValue") String value, @Param("qDetails") String details,
                                 @Param("qRemark") String remark, @Param("qStatus") Byte status,
                                 @Param("qSort") Short sort, @Param("qUpdateTime") Integer updateTime,
                                 @Param("qId") int id);
    //查询满足父类信息对象
    @Transactional
    @Query("select id,name,value,details,remark,status,sort from DictionaryEntity di where di.parent=:qParent")
    public List<DictionaryEntity> selectParent(@Param("qParent") Integer parent);

    /**
     *  查询父级节点
     * @param parent
     * @return
     */
    public List<DictionaryEntity> findByParent(Integer parent);

    public DictionaryEntity findById(int id);
}

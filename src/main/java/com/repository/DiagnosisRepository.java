package com.repository;

import com.model.DiagnosisEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by kevin on 17-3-2.
 */
public interface DiagnosisRepository extends JpaRepository<DiagnosisEntity, Integer> {

    public DiagnosisEntity findByRid(int id);
    public List<DiagnosisEntity> findByRidAndTypesOrderByCreateTime(int id,Byte types);
}

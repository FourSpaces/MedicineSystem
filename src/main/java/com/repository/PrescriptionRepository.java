package com.repository;

import com.model.PrescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kevin on 17-3-2.
 */
public interface PrescriptionRepository extends JpaRepository<PrescriptionEntity, Integer> {

}

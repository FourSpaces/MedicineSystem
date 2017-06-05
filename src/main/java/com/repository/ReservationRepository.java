package com.repository;

import com.model.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kevin on 17-2-16.
 */
public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer> {

    public ReservationEntity findByRidAndCreateTimeGreaterThan(Integer rid,Integer createTime);
}

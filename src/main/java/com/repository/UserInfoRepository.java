package com.repository;

import com.model.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kevin on 17-2-15.
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Integer> {


    //查询手机号对应用户
    public UserInfoEntity findByPhone(String phone);
}

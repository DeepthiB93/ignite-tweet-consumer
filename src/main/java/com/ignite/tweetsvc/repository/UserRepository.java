package com.ignite.tweetsvc.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ignite.tweetsvc.model.UserInfo;
import com.ignite.tweetsvc.model.UserInfoId;

@Repository
public interface UserRepository extends CrudRepository<UserInfo, UserInfoId>{

	@Query("SELECT t FROM UserInfo t where user_id = ?1")
	UserInfo getUserInfo(String userId);
}

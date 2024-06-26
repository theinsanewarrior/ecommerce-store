package com.store.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.store.models.User;

public interface UserRepository extends JpaRepository<User, String>{
	@Transactional
	@Modifying
	@Query("update User u set u.password=:pass where u.uid=:uid")
	void updateUserPassword(@Param("pass") String pass,@Param("uid") String uid);
}

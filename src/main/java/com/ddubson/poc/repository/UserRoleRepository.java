package com.ddubson.poc.repository;

import com.ddubson.poc.model.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRoleRepository")
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
	@Query("select a.role from UserRole a, User b where b.userName=?1 and a.userid=b.userId")
	List<String> findRoleByUserName(String username);
}

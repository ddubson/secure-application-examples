package com.ddubson.poc.repository;

import com.ddubson.poc.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUserName(String userName);
}

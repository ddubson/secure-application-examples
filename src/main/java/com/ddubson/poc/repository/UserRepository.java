package com.ddubson.poc.repository;

import com.ddubson.poc.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ddubson on 2/1/16.
 */
@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUserName(String username);
}

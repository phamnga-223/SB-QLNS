package com.qlns.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.qlns.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer> {

	@Query(value = "SELECT u FROM Admin u WHERE u.username = :username AND u.password = :password")
	public Admin getAdmin(@Param("username") String username, @Param("password") String password);

	@Query(value = "SELECT u FROM Admin u WHERE u.username = :username")
	public Admin getAdmin(@Param("username") String username);
}

package com.demo.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.emp.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	public User  findByUsername(String username);
}

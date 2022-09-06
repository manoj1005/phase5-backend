package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{
	@Query("Select a from Admin a where a.adminEmail=?1")
	public Admin findByMail(String adminEmail);

}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminDao;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminDao adao;
	
	@PostMapping("/add")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin ad){
		return ResponseEntity.ok(adao.addAdmin(ad));
	}
	
	@PostMapping("/login")
	public ResponseEntity<Admin> adminLogin(@RequestBody Admin ad){
		return ResponseEntity.ok(adao.adminLogin(ad));
	}

}

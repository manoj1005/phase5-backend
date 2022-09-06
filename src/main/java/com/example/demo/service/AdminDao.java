package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.repo.AdminRepo;

@Service
public class AdminDao {
	@Autowired
	public AdminRepo arepo;
	
	public Admin addAdmin(Admin a) {
		return arepo.save(a);
	}
	public Admin adminLogin(Admin a) {
		Admin anew=arepo.findByMail(a.getAdminEmail());
		if(anew.getPassword().equals(a.getPassword())) {
			return anew;
		}
		return null;
	}

}

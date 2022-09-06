package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;


@Service
public class UserDao {
	@Autowired
	public UserRepo urepo;
	
	public User addUser(User u) {
		return urepo.save(u);
	}

	public List<User> getAllUser() {
		return urepo.findAll();
	}

	public User getUserById(Integer id) {
		User a=urepo.findById(id).orElse(null);
		return a;
	}

	public User updateUser(User newUser) {
		User a=urepo.findById(newUser.getUserId()).orElse(null);
		a.setPhoneNo(newUser.getPhoneNo());
		a.setUserName(newUser.getUserName());
		a.setUserMail(newUser.getUserMail());
		a.setPassword(newUser.getPassword());
		return urepo.save(a);
	}
	public User login(User u) {
		User user=urepo.findByMail(u.getUserMail());
		if(user.getPassword().equals(u.getPassword())) {
			return user;
		}
		else {
		return null;
		}
	}
}

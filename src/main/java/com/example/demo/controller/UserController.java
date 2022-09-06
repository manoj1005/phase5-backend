package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserDao;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserDao udao;
	@Autowired
	private UserRepo urepo;
	
	@PostMapping("/reg")
	public ResponseEntity<User> adduser(@RequestBody User u){
		System.out.println("Controller called");
		return ResponseEntity.ok(udao.addUser(u));	
	}
	@GetMapping("/getall")
	public ResponseEntity<List<User>> getAllUser(){
		return ResponseEntity.ok(udao.getAllUser());
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<User> getUserByMailId(@PathVariable Integer id){
		User user= udao.getUserById(id);
		if(user!=null)
			return ResponseEntity.ok(user);
		else
			return null;
	}
	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User newUser){
		return ResponseEntity.ok(udao.updateUser(newUser));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id){
		boolean a=true;
		if(a) {
			urepo.deleteById(id);
			a=false;
		}
		if(!a) {
			return new ResponseEntity<String>("Object Deleted",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("NO user Found", HttpStatus.NOT_FOUND);
	}
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user){
		System.out.println("login reached"+user);
		return ResponseEntity.ok(udao.login(user));
	}

}

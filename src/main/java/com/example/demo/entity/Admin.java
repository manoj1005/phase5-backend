package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class Admin {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	int adminId;
	String adminName;
	String adminEmail;
	String password;
}

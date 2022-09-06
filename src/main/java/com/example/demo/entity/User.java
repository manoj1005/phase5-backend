package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class User {
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Id
	int userId;
	String userName;
	Long phoneNo;
	String userMail;
	String password;

}

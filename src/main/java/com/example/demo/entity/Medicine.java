package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data

public class Medicine {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	Double mrp;
	int quantity;
	String category;
	String drug_description;
}

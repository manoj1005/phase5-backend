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

import com.example.demo.entity.Medicine;
import com.example.demo.repo.MedicineRepo;
import com.example.demo.service.MedicineDao;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/med")
public class MedicineController {
	@Autowired
	private MedicineDao mdao;
	@Autowired
	private MedicineRepo mrepo;
	
	@PostMapping("/register")
	public ResponseEntity<Medicine> regmed(@RequestBody Medicine med){
		return ResponseEntity.ok(mdao.AddMedicine(med));
	}
	@GetMapping("/getall")
	public ResponseEntity<List<Medicine>> getallmed(){
		return ResponseEntity.ok(mrepo.findAll());
	}
	@PutMapping("/update")
	public ResponseEntity<Medicine> updateMed(@RequestBody Medicine med){
		return ResponseEntity.ok(mdao.updateMed(med));
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<Medicine> getMedById(@PathVariable Integer id){
		Medicine med= mdao.getMedById(id);
		if(med!=null)
			return ResponseEntity.ok(med);
		else
			return null;
	}
	@GetMapping("/byname/{name}")
	public ResponseEntity<Medicine> getMedByName(@PathVariable String name){
		Medicine med= mrepo.findMedByName(name);
		if(med!=null)
			return ResponseEntity.ok(med);
		else
			return null;
	}
	@DeleteMapping("/del/{id}")
	public ResponseEntity<String> deleteMed(@PathVariable Integer id){
		boolean a=true;
		if(a) {
		mrepo.deleteById(id);
		a=false;
		}
		if(!a) {
			return new ResponseEntity<String>("Medicine Deleted",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("NO Medicine Found", HttpStatus.NOT_FOUND);
	}
	

}

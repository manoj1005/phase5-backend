package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Medicine;
import com.example.demo.repo.MedicineRepo;

@Service
public class MedicineDao {
	@Autowired
	private MedicineRepo mrepo;
	
	public Medicine AddMedicine(Medicine med) {
		return mrepo.save(med);
	}
	public Medicine getMedById(Integer id) {
		Medicine med=mrepo.findById(id).orElse(null);
		return med;
	}
	public Medicine findmedbyname(Medicine med) {
		Medicine med1=mrepo.findMedByName(med.getName());
		return med1;
	}
	public Medicine updateMed(Medicine med) {
		Medicine newmed=mrepo.findById(med.getId()).orElse(null);
		newmed.setCategory(med.getCategory());
		newmed.setDrug_description(med.getDrug_description());
		newmed.setMrp(med.getMrp());
		newmed.setName(med.getName());
		newmed.setQuantity(med.getQuantity());
		return mrepo.save(newmed);
	}
}

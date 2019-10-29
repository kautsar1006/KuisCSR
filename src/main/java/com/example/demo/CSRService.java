package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CSRService {

	@Autowired
	private CSRRepository repo;
	
	public List<CSRModel> listALL() {
		return repo.findAll();
	}
	
	public void Save(CSRModel csr) {
		repo.save(csr);
	}
	
	public CSRModel get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
}

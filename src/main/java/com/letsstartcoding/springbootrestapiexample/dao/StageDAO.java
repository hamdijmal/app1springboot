package com.letsstartcoding.springbootrestapiexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsstartcoding.springbootrestapiexample.model.Stage;
import com.letsstartcoding.springbootrestapiexample.repository.StageRepository;

@Service
public class StageDAO {
	
	@Autowired
	StageRepository stageRepository;
	
	/*to save an employee*/
	
	public Stage save(Stage emp) {
		return stageRepository.save(emp);
	}
	
	
	/* search all employees*/
	
	public List<Stage> findAll(){
		return stageRepository.findAll();
	}
	
	
	/*get an employee by id*/
	public Stage findOne(Long empid) {
		return stageRepository.findOne(empid);
	}
	
	
	/*delete an employee*/
	
	public void delete(Stage emp) {
		stageRepository.delete(emp);
	}
	

}

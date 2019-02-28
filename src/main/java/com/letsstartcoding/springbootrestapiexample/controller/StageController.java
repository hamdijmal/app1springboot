package com.letsstartcoding.springbootrestapiexample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.letsstartcoding.springbootrestapiexample.dao.StageDAO;
import com.letsstartcoding.springbootrestapiexample.model.Stage;


@CrossOrigin
@RestController

@RequestMapping("/company")
public class StageController {
	
	@Autowired
	StageDAO stageDAO;
	
	/* to save an employee*/
	@PostMapping("/stages/add")
	public Stage createEmployee(@Valid @RequestBody Stage emp) {
		
		return stageDAO.save(emp);
	
	}
	
	/*get all employees*/
	@GetMapping("/stages")
	public List<Stage> getAllEmployees(){
		System.out.println("stages");
		return stageDAO.findAll();
	}
	
	/*get employee by empid*/
	@GetMapping("/stages/{id}")
	public ResponseEntity<Stage> getEmployeeById(@PathVariable(value="id") Long empid){
		
		Stage emp=stageDAO.findOne(empid);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
		
	}
	
	
	/*update an employee by empid*/
	@PutMapping("/stages/{id}")
	public ResponseEntity<Stage> updateEmployee(@PathVariable(value="id") Long empid,@Valid @RequestBody Stage empDetails){
		
		Stage emp=stageDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setAge(empDetails.getAge());
		emp.setFaculte(empDetails.getFaculte());
		emp.setNom_etuduant(empDetails.getNom_etuduant());
		
		Stage updateEmployee=stageDAO.save(emp);
		return ResponseEntity.ok().body(updateEmployee);
		
		
		
	}
	
	/*Delete an employee*/
	@DeleteMapping("/stages/{id}")
	public ResponseEntity<Stage> deleteEmployee(@PathVariable(value="id") Long empid){
		
		Stage emp=stageDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		stageDAO.delete(emp);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	

}

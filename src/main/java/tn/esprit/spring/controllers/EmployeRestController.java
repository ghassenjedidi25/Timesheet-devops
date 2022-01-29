package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.EmployeServiceImpl;


@RestController
public class EmployeRestController {
		@Autowired 
		EmployeServiceImpl es; 
	 
		@GetMapping("/retrieve-all-employee")
		public List<Employe> retrieveAllEmployees() {
			List<Employe> list = es.retrieveAllEmployees();
			return list;
		}
	 
		@GetMapping("/retrieve-employe/{employe-id}")
		public Employe retrieveUser(@PathVariable("employe-id") String employeId) {
			return es.retrieveEmploye(employeId);
		}

		@PostMapping("/add-employe")
		public Employe addEmploye(@RequestBody Employe u) {
			Employe employe = es.addEmploye(u); 
			return employe;
		}

		
		@DeleteMapping("/remove-employe/{employe-id}") 
		public void removeUser(@PathVariable("employe-id") String employeId) { 
			es.deleteEmploye(employeId);
		} 

		// Modifier User 
		// http://localhost:????/timesheet-devops/modify-user 
		@PutMapping("/modify-employe") 
		public Employe updateUser(@RequestBody Employe employe) {
			return es.updateEmploye(employe);
		}
}

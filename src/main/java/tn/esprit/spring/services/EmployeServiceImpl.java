package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements IEmployeService{

	@Autowired
	EmployeRepository er;
	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);

	
	@Override
	public List<Employe> retrieveAllEmployees() {
		List<Employe> employes = null; 
		try {
			
			l.info("In Method retrieveAllEmployees :");
			employes = (List<Employe>) er.findAll(); 
			l.debug("connexion à la DB Ok :"); 
			for (Employe employe : employes) {
				l.debug("user :" + employe.getNom()); 
			} 
			l.info("Out of Method retrieveAllEmployees with Success" + employes.size());
		}catch (Exception e) {
			l.error("Out of Method retrieveAllEmployees with Errors : " + e); 
		}

		return employes;
	}


	@Override
	public Employe addEmploye(Employe e) {
		Employe e_saved = null; 
		
		try {
			l.info("In Method addEmploye :");
			e_saved = er.save(e); 
			l.debug("connexion à la DB Ok :");			
		} catch (Exception er) {
			l.error("Out of Method addEmploye with Errors : " + er);
		}
		
		return e_saved; 
	}


	@Override
	public void deleteEmploye(String id) {
		try {
			l.info("In Method deleteContrat :");
			er.deleteById(Long.parseLong(id));
			l.debug("connexion à la DB Ok :");

		} catch (Exception e) {
			l.error("Out of Method deleteEmploye with Errors : " + e);
		}
		
	}


	@Override
	public Employe updateEmploye(Employe e) {
		Employe employeUpdated = null;

		try {
			l.info("In Method updateEmploye :");
			employeUpdated = er.save(e);
			l.debug("connexion à la DB Ok :");

		} catch (Exception er) {
			l.error("Out of Method updateEmploye with Errors : " + er);
		}

		return employeUpdated;
	}


	@Override
	public Employe retrieveEmploye(String id) {
		Employe e = null;
		try {
			l.info("In Method retrieveEmploye :");
			e = er.findById(Long.parseLong(id)).get();
			l.debug("connexion à la DB Ok :");

		} catch (Exception er) {
			l.error("Out of Method retrieveEmploye with Errors : " + er);
		}

		return e;
	}

	

}

package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repositories.DepartementRepository;


@Service
public class DepartementServiceImpl implements IDepartementService {
	
	@Autowired
	DepartementRepository departementRepository;
	
	private static final Logger l = LogManager.getLogger(DepartementServiceImpl.class);
	
	
	@Override
	public List<Departement> retrieveAllDepartements() {
		List<Departement> departements = null;
		try {

			l.info("In Method retrieveAllDepartements :");
			departements = (List<Departement>) departementRepository.findAll();
			l.debug("connexion à la DB Ok :");
			for (Departement departement : departements) {
				l.debug("departement :" + departement.getName());
			}
			l.info("Out of Method retrieveAllDepartements with Success" + departements.size());
		} catch (Exception e) {
			l.error("Out of Method retrieveAllDepartements with Errors : " + e);
		}

		return departements;
	}
	
	
	@Override
	public Departement addDepartement(Departement d) {
		Departement d_saved = null;

		try {
			l.info("In Method addDepartement :");
			d_saved = departementRepository.save(d);
			l.debug("connexion à la DB Ok :");

		} catch (Exception e) {
			l.error("Out of Method addDepartement with Errors : " + e);
		}

		return d_saved;
	}
	
	
	@Override
	public void deleteDepartement(String id) {
		try {
			l.info("In Method deleteDepartement :");
			departementRepository.deleteById(Long.parseLong(id));
			l.debug("connexion à la DB Ok :");

		} catch (Exception e) {
			l.error("Out of Method deleteDepartement with Errors : " + e);
		}

	}
	
	
	@Override
	public Departement updateDepartement(Departement d) {
		Departement departementUpdated = null;

		try {
			l.info("In Method updateDepartement :");
			departementUpdated = departementRepository.save(d);
			l.debug("connexion à la DB Ok :");

		} catch (Exception e) {
			l.error("Out of Method updateDepartement with Errors : " + e);
		}

		return departementUpdated;
	}
	
	
	@Override
	public Departement retrieveDepartement(String id) {
		Departement departement = null;
		try {
			l.info("In Method retrieveDepartement :");
			departement = departementRepository.findById(Long.parseLong(id)).get();
			l.debug("connexion à la DB Ok :");

		} catch (Exception e) {
			l.error("Out of Method retrieveDepartement with Errors : " + e);
		}

		return departement;
	}

}

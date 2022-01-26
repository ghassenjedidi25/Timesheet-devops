package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repositories.EntrpriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
	EntrpriseRepository entrpriseRepository;

	private static final Logger l = LogManager.getLogger(EntrepriseServiceImpl.class);

	@Override
	public List<Entreprise> retrieveAllEntreprises() {
		List<Entreprise> entreprises = null;
		try {

			l.info("In Method retrieveAllEntreprise :");
			entreprises = (List<Entreprise>) entrpriseRepository.findAll();
			l.debug("connexion à la DB Ok :");
			for (Entreprise entreprise : entreprises) {
				l.debug("user :" + entreprise.getName());
			}
			l.info("Out of Method retrieveAllEntreprise with Success" + entreprises.size());
		} catch (Exception e) {
			l.error("Out of Method retrieveAllEntreprise with Errors : " + e);
		}

		return entreprises;
	}

	@Override
	public Entreprise addEntreprise(Entreprise u) {
		Entreprise e_saved = null;

		try {
			l.info("In Method addEntreprise :");
			e_saved = entrpriseRepository.save(u);
			l.debug("connexion à la DB Ok :");

		} catch (Exception e) {
			l.error("Out of Method addEntreprise with Errors : " + e);
		}

		return e_saved;
	}

	@Override
	public void deleteEntreprise(String id) {
		try {
			l.info("In Method deleteEntreprise :");
			entrpriseRepository.deleteById(Long.parseLong(id));
			l.debug("connexion à la DB Ok :");

		} catch (Exception e) {
			l.error("Out of Method deleteEntreprise with Errors : " + e);
		}

	}

	@Override
	public Entreprise updateEntreprise(Entreprise u) {
		Entreprise entrepriseUpdated = null;

		try {
			l.info("In Method updateEntreprise :");
			entrepriseUpdated = entrpriseRepository.save(u);
			l.debug("connexion à la DB Ok :");

		} catch (Exception e) {
			l.error("Out of Method updateEntreprise with Errors : " + e);
		}

		return entrepriseUpdated;
	}

	@Override
	public Entreprise retrieveEntreprise(String id) {
		Entreprise entreprise = null;
		try {
			l.info("In Method retrieveEntreprise :");
			entreprise = entrpriseRepository.findById(Long.parseLong(id)).get();
			l.debug("connexion à la DB Ok :");

		} catch (Exception e) {
			l.error("Out of Method retrieveEntreprise with Errors : " + e);
		}

		return entreprise;
	}

}

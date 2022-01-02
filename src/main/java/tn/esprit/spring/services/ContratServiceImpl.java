package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repositories.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {

	@Autowired
	ContratRepository Cr;

	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);

	@Override
	public List<Contrat> retrieveAllContrats() {

		List<Contrat> contrats = null;
		try {

			l.info("In Method retrieveAllContrat :");
			contrats = (List<Contrat>) Cr.findAll();
			l.debug("connexion à la DB Ok :");
			for (Contrat contrat : contrats) {
				l.debug("user :" + contrat.getTypeContrat());
			}
			l.info("Out of Method retrieveAllContrat with Success" + contrats.size());
		} catch (Exception e) {
			l.error("Out of Method retrieveAllContrat with Errors : " + e);
		}

		return contrats;
	}

	@Override
	public Contrat addContrat(Contrat c) {

		Contrat c_saved = null;

		try {
			l.info("In Method addContrat :");
			c_saved = Cr.save(c);
			l.debug("connexion à la DB Ok :");

		} catch (Exception e) {
			l.error("Out of Method addContrat with Errors : " + e);
		}

		return c_saved;
	}

	@Override
	public void deleteContrat(String id) {
		try {
			l.info("In Method deleteContrat :");
			Cr.deleteById(Long.parseLong(id));
			l.debug("connexion à la DB Ok :");

		} catch (Exception e) {
			l.error("Out of Method deleteContrat with Errors : " + e);
		}

	}

	@Override
	public Contrat updateContrat(Contrat c) {

		Contrat contratUpdated = null;

		try {
			l.info("In Method updateContrat :");
			contratUpdated = Cr.save(c);
			l.debug("connexion à la DB Ok :");

		} catch (Exception e) {
			l.error("Out of Method updateContrat with Errors : " + e);
		}

		return contratUpdated;
	}

	@Override
	public Contrat retrieveContrat(String id) {
		Contrat c = null;
		try {
			l.info("In Method retrieveContrat :");
			c = Cr.findById(Long.parseLong(id)).get();
			l.debug("connexion à la DB Ok :");

		} catch (Exception e) {
			l.error("Out of Method retrieveContrat with Errors : " + e);
		}

		return c;
	}

}

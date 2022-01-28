package tn.esprit.spring;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.EntrepriseServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class TimeSheetDevopsApplicationTests {


	@Autowired
	EntrepriseServiceImpl es;

	@Test
	@Order(1)
	public void testRetrieveAllEntreprises() {
		List<Entreprise> listEntreprises = es.retrieveAllEntreprises();
		Assertions.assertEquals(0, listEntreprises.size());
	}
	@Test
	@Order(2)
	public void testAddEntreprisee() throws ParseException{
		Entreprise e = new Entreprise("entreprise1", "raisonSocialEntreprise1");
		Entreprise addedEntreprise = es.addEntreprise(e);
		Assertions.assertEquals(e.getName(),addedEntreprise.getName());
	}
	
	@Test
	@Order(3)
	public void testUpdateEntreprisee() throws ParseException{
		Entreprise e = new Entreprise("entreprise1.1", "raisonSocialEntreprise1");
		Entreprise updatedEntreprise = es.updateEntreprise(e);
		Assertions.assertEquals(e.getName(),updatedEntreprise.getName());
	}
	
	@Test
	@Order(4)
	public void testRetriveEntreprisee() throws ParseException{
		Entreprise userRetrived = es.retrieveEntreprise("1");
		Assertions.assertEquals(1L,userRetrived.getId());
	}
	
	@Test
	@Order(5)
	public void testDeleteEntreprisee() throws ParseException{
		es.deleteEntreprise("1");
		Assertions.assertNull(es.retrieveEntreprise("1"));
	}
}

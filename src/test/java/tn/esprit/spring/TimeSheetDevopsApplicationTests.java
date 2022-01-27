package tn.esprit.spring;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.DepartementServiceImpl;

@SpringBootTest
public class TimeSheetDevopsApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	DepartementServiceImpl Cs;

	@Test
	public void testRetrieveAllDepartements() {
		List<Departement> listdepartements = Cs.retrieveAllDepartements();
		Assertions.assertEquals(0, listdepartements.size());
	}

}

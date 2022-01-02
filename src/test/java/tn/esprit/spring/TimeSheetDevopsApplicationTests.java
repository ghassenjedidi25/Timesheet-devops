package tn.esprit.spring;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;

@SpringBootTest
public class TimeSheetDevopsApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	IContratService Cs;

	@Test
	public void testRetrieveAllUsers() {
		List<Contrat> listcontrats = Cs.retrieveAllContrats();
		Assertions.assertEquals(0, listcontrats.size());
	}

}

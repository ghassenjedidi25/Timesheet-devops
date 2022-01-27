package tn.esprit.spring;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.EmployeServiceImpl;

@SpringBootTest
public class TimeSheetDevopsApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	EmployeServiceImpl es;

	@Test
	public void testRetrieveAllDepartements() {
		List<Employe> listEmployees = es.retrieveAllEmployees();
		Assertions.assertEquals(0, listEmployees.size());
	}
}

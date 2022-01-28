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

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.EmployeServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class TimeSheetDevopsApplicationTests {


	@Autowired
	EmployeServiceImpl es;

	@Test
	@Order(1)
	public void testRetrieveAllEmployees() {
		List<Employe> listEmployees = es.retrieveAllEmployees();
		Assertions.assertEquals(0, listEmployees.size());
	}
	@Test
	@Order(2)
	public void testAddEmployee() throws ParseException{
		Employe e = new Employe("ghassen","jedidi", "jedidighassen@gmail.com", false, null);
		Employe addedEmploye = es.addEmploye(e);
		Assertions.assertEquals(e.getNom(),addedEmploye.getNom());
	}
	
	@Test
	@Order(3)
	public void testUpdateEmployee() throws ParseException{
		Employe e = new Employe("test","jedidi", "jedidighassen@gmail.com", false, null);
		Employe updatedEmploye = es.updateEmploye(e);
		Assertions.assertEquals(e.getNom(),updatedEmploye.getNom());
	}
	
	@Test
	@Order(4)
	public void testRetriveEmployee() throws ParseException{
		Employe userRetrived = es.retrieveEmploye("1");
		Assertions.assertEquals(1L,userRetrived.getId());
	}
	
	@Test
	@Order(5)
	public void testDeleteEmployee() throws ParseException{
		es.deleteEmploye("1");
		Assertions.assertNull(es.retrieveEmploye("1"));
	}
}

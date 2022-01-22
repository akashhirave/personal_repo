package com.jbk.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.jbk.dao.EmployeeDAO;
import com.jbk.entity.Emplyoee;

class EmployeeServiceTest {

	@InjectMocks// it will inject controller class in to the Test class after instantiating
	EmployeeService service;
	@Mock // it will just create nocking class into the test class 
	EmployeeDAO dao;
	
	@BeforeEach
	void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);// it will initialize the mock object 
	}

	@Test
	void testGetParticularEMP() {
		Emplyoee e= new Emplyoee();
		e.setId(12);
		e.setName("akki");
		
		when(dao.getParticularEMP(anyInt())).thenReturn(e);
		Emplyoee emp;
		try {
			emp = service.getParticularEMP(10);
		
		assertNotNull(emp);
		assertEquals("akki", emp.getName());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

//		fail("Not yet implemented");
	}

	@Test
	//In Junit 4 we user to write (expected= class of exception)
	void testGetParticularEMP_withException() throws Exception {
	when(dao.getParticularEMP(anyInt())).thenReturn(null);
	assertThrows(Exception.class, 
			()->{
				
				service.getParticularEMP(10);
			}
			);
	


	} 
}

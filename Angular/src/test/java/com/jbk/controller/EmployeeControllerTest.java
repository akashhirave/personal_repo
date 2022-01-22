package com.jbk.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.jbk.entity.Emplyoee;
import com.jbk.service.EmployeeService;

class EmployeeControllerTest {

	@Mock
	EmployeeService service;
	
	@InjectMocks
	EmployeeController ctrl;
	@BeforeEach
	void setUp() throws Exception {
		//MockitoAnnotations.initMocks(this);

	}

	@Test
	void testGetParticularEMP() {
		Emplyoee emp= new Emplyoee();
		emp.setId(12);
		emp.setName("akki");
		try {
			when(service.getParticularEMP(anyInt())).thenReturn(emp);
			Emplyoee emp2=ctrl.getParticularEMP(10);
			
			assertNotNull(emp2);
			assertEquals("akki", emp2.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		fail("Not yet implemented");
	}

}

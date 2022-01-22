package com.jbk.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.jbk.entity.Emplyoee;

class EmployeeDAOTest {

	@Mock
	SessionFactory sessionFactory;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetParticularEMP() {
		when(sessionFactory.openSession()
				.createCriteria(Emplyoee.class)
				.add(Restrictions.eq("id",anyString())))
				.thenReturn(null);    
//		fail("Not yet implemented");
	}

}
 
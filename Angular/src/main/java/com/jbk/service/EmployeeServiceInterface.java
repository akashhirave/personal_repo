package com.jbk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jbk.entity.Country;
@Service
public interface EmployeeServiceInterface {
	
	public String AddCountry(Country c);
	public List<Country> GetAllCountry();
	
	//All method Should be present
}

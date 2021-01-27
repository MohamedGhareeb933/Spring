package com.shapara.springdemo.mvc;

import java.util.ArrayList;
import java.util.List;

public class Student {
	
	private String firstName;
	private String lastName;
	private String Country;
	private String favLanguage;
	private String[] operatingSystem;
	
	private List<String> languageList;
	private List<String> operatingSystemList;
	
	private PropertiesList propertiesListMethod;

	Student(){
		
		propertiesListMethod = new PropertiesList();
		
		languageList = propertiesListMethod.LanguageArrayList();
		operatingSystemList = propertiesListMethod.opertingSystemArrayList();
	}
	
	public String getFavLanguage() {
		return favLanguage;
	}
	public void setFavLanguage(String favLanguage) {
		this.favLanguage = favLanguage;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	
	public String[] getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String[] operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	
	public List<String> getLanguageList(){
		return languageList;
	}
	
	public List<String> getOperatingSystemList() {
		return operatingSystemList;
	}

}

package com.shapara.springdemo.mvc;

import java.util.ArrayList;
import java.util.List;

public class PropertiesList {
	
	public List<String> LanguageArrayList() {
		
		List languageList = new ArrayList<>();
		
		languageList.add("C++");
		languageList.add("Java");
		languageList.add("Python");
		languageList.add("PHP");
		
		return languageList;
	}
	
	
	public List<String> opertingSystemArrayList() {
		
		List operatingList = new ArrayList<>();
		
		operatingList.add("Linux");
		operatingList.add("MAC OS");
		operatingList.add("Windows");
		
		return operatingList;
	}

}

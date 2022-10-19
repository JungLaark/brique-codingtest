package com.brique.codingtest;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.brique.codingtest.model.NumberFive;
import com.brique.codingtest.model.NumberThree;
import com.brique.codingtest.service.MainService;


@RestController
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	@GetMapping("/numberthree")
	public String numberThree() {
		List<NumberThree> result = new ArrayList<>();
		result = mainService.selectEmp();
		String stringList = "";
		
		for(NumberThree numberFour: result) {
			stringList += numberFour.getEmpNo() + "					" + 
		                  numberFour.getFirstName() + "					" + 
		                  numberFour.getLastName() + "					" + 
		                  numberFour.getGender() + "					" + 
		                  numberFour.getHireDate() + "					" + 
		                  numberFour.getDeptName() + "					" + 
		                  numberFour.getTitle() + "					" + 
		                  numberFour.getSalary() + "<br>";
		}
		stringList = stringList + "<br><button onclick=\"location.href='/'\">메인으로</button>";
		
		return stringList ;
	}
	
	
	
	@GetMapping("/numberfive")
	public String numberFive() {
		
		NumberFive numberFive;
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Integer> map = new HashMap<String, Integer>();
		String uri = "http://codingtest.brique.kr:8080/random";
		String key = "";
		String result = "";
		int sum = 0;
		
		for(int i=0; i<100; i++) {
			 numberFive = restTemplate.getForObject(uri, NumberFive.class);
			 key = numberFive.getId()+", " +numberFive.getQuote();
			 
			 if(!map.containsKey(key)){
				 map.put(key, 1);
			 }else {
				 int origin = map.get(key);
				 int newValue = origin + 1;
				 
				 map.put(key, newValue);
			 }
		}
		
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map.entrySet());
		
		Collections.sort(list, new Comparator<Entry<String, Integer>>(){

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		for(Entry<String, Integer> entry: list) {
			result += "Count: "+ entry.getValue() + "     [ " + entry.getKey() + "] <br>" ;
			sum += entry.getValue();
		}
		
		result += "<br>  Total count :   " + sum + "<br><button onclick=\"location.href='/'\">메인으로</button>"; 
		
		return result;
	}

}

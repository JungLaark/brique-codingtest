package com.brique.codingtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brique.codingtest.mapper.MainMapper;
import com.brique.codingtest.model.NumberThree;

@Service
public class MainService {
	
	@Autowired
	private MainMapper mainMapper;

	public MainService() {
		
	}
	
	public List<NumberThree> selectEmp() {
		return mainMapper.selectEmp();
	}

}

package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	// create and array of string;
	String [] data = {"Think Big", "Be determine", "Work Ethic"};
	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		// pick a random string from the array.
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		
		return theFortune;
	}

}

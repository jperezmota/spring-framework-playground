package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("jperezCoach")
public class JonathanCoach implements Coach {
	
    private FortuneService fortuneService;
	
    
	@Autowired
	public JonathanCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Your dialy workout by Jonathan.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

package com.shapara.springdemo;

import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class RandomService implements FortuneService {
	
	Random rand = new Random();
	
	private String randLuck[] = {"Be Aware Of you'r Day ",
			"You'r Day isn't the Best ",
			"it's good Day Keep Going On",
			"it's Really yout Lucky Day"
			};
	
	 int index = rand.nextInt(randLuck.length);
	
	@Override
	public String GetFortuneService() {
		return randLuck[index];
	}

}

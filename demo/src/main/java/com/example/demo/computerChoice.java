package com.example.demo;

import java.util.Random;

public class computerChoice {

	public String computerchoice() {

		Random random = new Random();
		int randomNumber = random.nextInt(3);
		if (randomNumber == 0) {
			return "sten";
		}
		if (randomNumber == 1) {
			return "påse";
		}

		if (randomNumber == 2) {
			return "sax";
		} else
			return "error";
	}

}

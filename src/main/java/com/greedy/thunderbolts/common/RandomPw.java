package com.greedy.thunderbolts.common;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RandomPw {
	
	private final String[] charLower = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	private final String[] charUpper = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private final String[] number =  {"1","2","3","4","5","6","7","8","9","0"};
	private final String[] sign =  {"!", "@", "#", "$", "%", "^", "&", "*", "(" ,")"};
	
	@Bean
	public String randowPws() {

		Random rand = new Random();
		String randomPw = "";
		boolean hasLower = false, hasUpper = false, hasNumber = false, hasSign = false;

		if (!(hasLower && hasUpper && hasNumber && hasSign)) {
			for (int i = 0; i < 16; i++) {
				int index = rand.nextInt(4);
				switch (index) {
				case 0: {
					int charLowerIndex = (int) (Math.random() * (charLower.length));
					randomPw = randomPw + charLower[charLowerIndex];
					hasLower = true;
				}
					break;
				case 1: {
					int charUpperIndex = (int) (Math.random() * (charUpper.length));
					randomPw = randomPw + charUpper[charUpperIndex];
					hasUpper = true;
				}
					break;
				case 2: {
					int numberIndex = (int) (Math.random() * (number.length));
					randomPw = randomPw + number[numberIndex];
					hasNumber = true;
				}
					break;
				case 3: {
					int signIndex = (int) (Math.random() * (sign.length));
					randomPw = randomPw + sign[signIndex];
					hasSign = true;
				}
					break;

				}

			}
		}
		StringBuilder sb = new StringBuilder(randomPw);

		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < charLower.length; j++) {
				if (randomPw.charAt(i) == charLower[j].charAt(0)) {
					sb.setCharAt(rand.nextInt(randomPw.length()), charLower[rand.nextInt(charLower.length)].charAt(0));
					randomPw = sb.toString();
				}
			}
			for (int j = 0; j < charUpper.length; j++) {
				if (randomPw.charAt(i) == charUpper[j].charAt(0)) {
					sb.setCharAt(rand.nextInt(randomPw.length()), charUpper[rand.nextInt(charUpper.length)].charAt(0));
					randomPw = sb.toString();
				}
			}
			for (int j = 0; j < number.length; j++) {
				if (randomPw.charAt(i) == number[j].charAt(0)) {
					sb.setCharAt(rand.nextInt(randomPw.length()), number[rand.nextInt(number.length)].charAt(0));
					randomPw = sb.toString();
				}
			}
			for (int j = 0; j < sign.length; j++) {
				if (randomPw.charAt(i) == sign[j].charAt(0)) {
					sb.setCharAt(rand.nextInt(randomPw.length()), sign[rand.nextInt(sign.length)].charAt(0));
					randomPw = sb.toString();
				}
			}
		}

		return randomPw;

	}
	
	
	
}
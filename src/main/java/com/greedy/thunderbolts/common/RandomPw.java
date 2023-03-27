package com.greedy.thunderbolts.common;

import java.util.Random;

public class RandomPw {
	
	private final String[] charLower = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	private final String[] charUpper = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private final String[] number =  {"1","2","3","4","5","6","7","8","9","0"};
	private final String[] sign =  {"!", "@", "#", "$", "%", "^", "&", "*", "(" ,")"};
	
	
	public String randowPws() {
	
		Random	rand = new Random();
		String randomPw = "";

		for (int i = 0; i < 16; i++) {
			int index = rand.nextInt(4);
			switch (index) {
			case 0: {
				int charLowerIndex = (int) Math.random() * (charLower.length);
				randomPw = randomPw + charLower[charLowerIndex];
			}
				break;
			case 1: {
				int charUpperIndex = (int) Math.random() * (charUpper.length);
				randomPw = randomPw + charUpper[charUpperIndex];
			}
				break;
			case 2: {
				int numberIndex = (int) Math.random() * (number.length);
				randomPw = randomPw + number[numberIndex];
			}
				break;
			case 3: {
				int signIndex = (int) Math.random() * (sign.length);
				randomPw = randomPw + sign[signIndex];
			}
				break;

			}
		
	}	
		
	
		for(int i =0; i<16; i++) {
			for(int j =0; j<charLower.length; j++) {
				if(randomPw.charAt(0) == charLower[j].charAt(0)) {
					
				}
			}
		}
		
	return randomPw;
	
	}
	
	
	
}

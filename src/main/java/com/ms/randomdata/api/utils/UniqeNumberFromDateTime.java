package com.ms.randomdata.api.utils;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.time.LocalDateTime;

public class UniqeNumberFromDateTime {

	public static BigInteger generateUniqueNumberFromTime() {

		LocalDateTime now = LocalDateTime.now();
		// Don't use Random class because there is probability that it would generate
		// same number.
		// So, please use SecureRandom class which is designed to generate
		// cryptographically new number only.
		SecureRandom secureRandom = new SecureRandom();
		int randomNumber = secureRandom.nextInt(900) + 100; // generates random no. between 10 and 100
//        System.out.println("Random number : " + randomNumber);

		StringBuilder uniqueNumber = new StringBuilder();
		uniqueNumber = uniqueNumber.append(now.toString()).replace(4, 5, "").replace(6, 7, "").replace(8, 9, "")
				.replace(10, 11, "").replace(12, 13, "").replace(14, 15, "").append(randomNumber);

//      uniqueNumber = uniqueNumber.append("20230113083553282779688");
//      uniqueNumber = uniqueNumber.append("20230113083553282779688000123");
		if (uniqueNumber.length() != 26) {
			// Below condition is required because some times length of time is less then 26
			// chars.
			if (uniqueNumber.length() < 26) {
				while (uniqueNumber.length() < 26) {
					uniqueNumber.append("0");
				}
			}
			// Below condition is a precautionary step for different-different Operating
			// Systems.
			if (uniqueNumber.length() > 26) {
				while (uniqueNumber.length() > 26) {
					uniqueNumber.deleteCharAt(26);
				}
			}
		}

		System.out.println("Generated Unique Number from DateTime : " + uniqueNumber);
		return (new BigInteger(uniqueNumber.toString()));
	}

}

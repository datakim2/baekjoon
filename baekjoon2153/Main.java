package baekjoon2153;

import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String word = br.readLine();

		int sum = 0;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c >= 'a' && c <= 'z') {
				sum += c - 'a' + 1;
			} else {
				sum += c - 'A' + 27;
			}
		}
		BigInteger check = new BigInteger(String.valueOf(sum));

		if (sum==1 || check.isProbablePrime(10)) {
			System.out.println("It is a prime word.");
		} else {
			System.out.println("It is not a prime word.");
		}
	}

}

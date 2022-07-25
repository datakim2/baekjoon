package baekjoon8595;

import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = stoi(br.readLine());

		String word = br.readLine();

		BigInteger sum = new BigInteger("0");
		StringBuilder sb = new StringBuilder();

		boolean isPossible = false;

		for (int i = 0; i < N; i++) {

			if (word.charAt(i) >= '0' && word.charAt(i) <= '9') {
				sb.append(word.charAt(i) - '0');
			} else {
				if (sb.toString().length() > 0) {
					sum = sum.add(new BigInteger(sb.toString()));
					isPossible = true;
				}
				sb = new StringBuilder();
			}
		}
		if (sb.toString().length() > 0) {
			sum = sum.add(new BigInteger(sb.toString()));
			isPossible = true;
		}

		if (isPossible)
			System.out.println(sum);
		else {
			System.out.println(0);
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}

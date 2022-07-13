package baekjoon14405;

import java.io.*;

public class Main {
	static boolean isPossible = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String word = br.readLine();

		check(word);

		if (isPossible && !word.equals("")) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	static void check(String word) {

		if (charCheck(word)) {
			isPossible = true;
			return;
		}

		String temp = word;

		temp = temp.replace("pi", "1");

		if (!temp.equals(word)) {
			check(temp);
		}

		temp = word;

		temp = temp.replace("ka", "1");
		if (!temp.equals(word)) {
			check(temp);
		}

		temp = word;

		temp = temp.replace("chu", "1");
		if (!temp.equals(word)) {
			check(temp);
		}

	}

	static boolean charCheck(String word) {
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) - 'a' >= 0 && word.charAt(i) - 'a' <= 25) {
				return false;
			}
		}
		return true;
	}

}

package baekjoon23037;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String word = br.readLine();

		long sum = 0;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int a = c - '0';

			sum += (int) Math.pow(a, 5);
		}

		System.out.println(sum);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}

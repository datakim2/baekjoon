package baekjoon11721;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String word = br.readLine();

		for (int i = 1; i <= word.length(); i++) {
			sb.append(word.charAt(i - 1));
			if (i % 10 == 0)
				sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}

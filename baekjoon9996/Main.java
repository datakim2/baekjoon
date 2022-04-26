package baekjoon9996;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split("\\*");

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			boolean isPossible = true;
			int size = word.length();

			for (int j = 0; j < s[0].length(); j++) {
				size--;
				if (word.charAt(j) != s[0].charAt(j)) {
					isPossible = false;
					break;
				}
			}
			if (size <= 0) {
				isPossible = false;
			}
			if (isPossible) {
				for (int j = s[1].length() - 1; j >= 0; j--) {
					size--;
					if (word.charAt(word.length() - (s[1].length() - j)) != s[1].charAt(j)) {
						isPossible = false;
						break;
					}
				}
				if (size < 0) {
					isPossible = false;
				}
			}
			if (!isPossible)
				sb.append("NE").append("\n");
			else
				sb.append("DA").append("\n");

		}

		System.out.println(sb.toString());
	}

}

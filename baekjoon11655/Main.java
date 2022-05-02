package test;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
				sb.append(s.charAt(i));
				continue;
			}

			char c = 0;
			if (s.charAt(i) >= 65 && s.charAt(i) <= 77) {
				c = (char) (s.charAt(i) + 13);
			} else if (s.charAt(i) >= 78 && s.charAt(i) <= 90) {
				c = (char) (((s.charAt(i) + 13)) % 91 + 65);
			} else if (s.charAt(i) >= 97 && s.charAt(i) <= 109) {
				c = (char) (s.charAt(i) + 13);
			} else if (s.charAt(i) >= 110 && s.charAt(i) <= 122) {
				c = (char) (((s.charAt(i) + 13) % 123) + 97);
			} else {
				sb.append(s.charAt(i));
				continue;
			}

			sb.append(c);
		}

		System.out.println(sb.toString());
	}

}

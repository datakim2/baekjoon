package baekjoon9086;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = stoi(br.readLine());

		for (int i = 0; i < T; i++) {
			String word = br.readLine();
			sb.append(word.charAt(0));
			sb.append(word.charAt(word.length() - 1));
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}

package baekjoon4562;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = stoi(br.readLine());

		for (int i = 0; i < T; i++) {
			String[] s = br.readLine().split(" ");
			int A = stoi(s[0]);
			int B = stoi(s[1]);
			if (A < B) {
				sb.append("NO BRAINS").append("\n");
			} else {
				sb.append("MMM BRAINS").append("\n");
			}
		}

		System.out.println(sb.toString());
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}

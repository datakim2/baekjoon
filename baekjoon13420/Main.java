package baekjoon13420;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long T = stoi(br.readLine());

		for (int i = 0; i < T; i++) {
			String[] s = br.readLine().split(" ");

			long A = stoi(s[0]);
			long B = stoi(s[2]);
			long C = stoi(s[4]);

			switch (s[1]) {
			case "*": {
				if (C == A * B) {
					sb.append("correct").append("\n");
				} else {
					sb.append("wrong answer").append("\n");
				}
				break;
			}
			case "+": {
				if (C == A + B) {
					sb.append("correct").append("\n");
				} else {
					sb.append("wrong answer").append("\n");
				}
				break;
			}
			case "-": {
				if (C == A - B) {
					sb.append("correct").append("\n");
				} else {
					sb.append("wrong answer").append("\n");
				}
				break;
			}
			case "/": {
				if (B != 0 && C == A / B) {
					sb.append("correct").append("\n");
				} else {
					sb.append("wrong answer").append("\n");
				}
				break;
			}
			}
		}

		System.out.println(sb.toString());
	}

	static long stoi(String s) {
		return Long.parseLong(s);
	}

}
